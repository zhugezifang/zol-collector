package org.example;

import org.example.utils.CnmoParamParse;
import org.example.utils.ParamParse;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CnmoPageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);

    public static final String URL_LIST = "pro_sub_manu";

    public static final String URL_CONTENT = "param";

    public static final String content_url = "https://product.cnmo.com{}param.shtml";

    private Map<String, ZolResult> zolResultMap = new HashMap<>();

    @Override
    public void process(Page page) {
        //列表页
        if (page.getUrl().regex(URL_LIST).match()) {
            List<String> list = page.getHtml().xpath("//ul[@class='all-con-con-ul']/li").all();
            if (list.size() > 0) {
                List<String> urlList = new ArrayList<>();
                for (String s : list) {
                    String[] arr = s.split("href");
                    try {
                        String productId = arr[1].split(".shtml")[0].split("index")[1];
                        int index = Integer.parseInt(productId.substring(0, 4)) + 1;
                        String url = "/" + index + "/" + productId + "/";
                        String listUrl = page.getUrl().get();

                        ZolResult zolResult = new ZolResult();
                        zolResult.setProductId(productId);
                        zolResult.setListUrl(listUrl);
                        zolResult.setPrice(CnmoParamParse.parsePrice(s));
                        zolResult.setOnlineDate(CnmoParamParse.parseOnlineDate(s));

                        zolResultMap.put(productId, zolResult);

                        url = content_url.replace("{}", url);
                        urlList.add(url);
                    } catch (Exception e) {

                    }
                }
                page.addTargetRequests(urlList);
            }
            //详细参数页
        } else if (page.getUrl().regex(URL_CONTENT).match()) {

            String productId = page.getUrl().get().split("\\/")[4];
            String contentUrl = page.getUrl().get();
            String title = page.getHtml().xpath("//b[@id='proName']/a/text()").get().split("\\(")[0];

            List<String> list = page.getHtml().xpath("//div[@id='cell-con-table']/ul").all();

            String onlineDate = null;
            String ram = null;
            String rom = null;
            String price = null;

            if (list.size() > 0) {
                for (String param : list) {
                    //RAM
                    if (ram == null) {
                        ram = CnmoParamParse.parseRam(param);
                    }
                    //ROM
                    if (rom == null) {
                        rom = CnmoParamParse.parseRom(param);
                    }
                }
            }
            ZolResult zolResult = zolResultMap.get(productId);
            if (zolResult == null) {
                System.out.println("======zolResult is nulll========");
            } else {
                zolResult.setParamUrl(contentUrl);
                zolResult.setTitle(title.split("\\（")[0]);
                zolResult.setRam(ram);
                zolResult.setRom(rom);
                zolResultMap.put(productId, zolResult);
                page.putField(productId, zolResult);
            }
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        String[] baseUrls = new String[]{
                "https://product.cnmo.com/pro_sub_manu/sub_57_manu_544_${i}.shtml"
        };
        String[] urls = new String[10 * baseUrls.length];
        int num = 0;
        for (int i = 0; i < baseUrls.length; i++) {
            for (int j = 0; j < 10; j++) {
                String str = baseUrls[i].replace("${i}", (j + 1) + "");
                urls[num] = str;
                num++;
            }
        }
        Spider.create(new CnmoPageProcessor()).addUrl(urls).addPipeline(new ConsolePipeline()).thread(baseUrls.length).run();
    }
}
