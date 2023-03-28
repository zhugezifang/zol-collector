package org.example;

import org.example.utils.ParamParse;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZoLPageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);

    public static final String URL_LIST = "cell_phone_index";

    public static final String URL_CONTENT = "param";

    public static final String content_url = "https://detail.zol.com.cn{}param.shtml";

    private Map<String, ZolResult> zolResultMap = new HashMap<>();

    private Map<String, String> brand = new HashMap<String, String>() {{
        put("subcate57_613", "华为");
        put("subcate57_1795", "vivo");
        put("subcate57_1673", "OPPO");
        put("subcate57_544", "苹果");
        put("subcate57_98", "三星");
        put("subcate57_50840", "荣耀");
        put("subcate57_55075", "iQOO");
        put("subcate57_34645", "小米");
        put("subcate57_35579", "一加");
        put("subcate57_1434", "魅族");
        put("subcate57_55535", "真我");
        put("subcate57_35005", "努比亚");
        put("subcate57_55731", "红米");
        put("subcate57_295", "Moto");
        put("subcate57_642", "中兴");
        put("subcate57_57933", "Hi nova");
        put("subcate57_1763", "联想");
        put("subcate57_1069", "索尼移动");
        put("subcate57_53765", "黑鲨");
        put("subcate57_297", "诺基亚");
        put("subcate57_1922", "谷歌");
        put("subcate57_41373", "ROG");
        put("subcate57_41412", "VERTU");
        put("subcate57_33992", "乐视");
        put("subcate57_57729", "麦芒");
        put("subcate57_57921", "鼎桥通信");
        put("subcate57_57398", "U-MAGIC");
        put("subcate57_35320", "小辣椒");
        put("subcate57_143", "LG");
        put("subcate57_57961", "魅蓝");
        put("subcate57_57658", "NZONE");
        put("subcate57_1606", "酷派");
        put("subcate57_58554", "WIKO");
        put("subcate57_1632", "金立");
        put("subcate57_57939", "Nothing");
        put("subcate57_227", "华硕");
        put("subcate57_34660", "AGM");
        put("subcate57_56290", "遨游");
        put("subcate57_19", "海信");
        put("subcate57_364", "微软");
        put("subcate57_12772", "黑莓");
        put("subcate57_55893", "多亲");
        put("subcate57_56901", "Unihertz");
        put("subcate57_35416", "中国电信");
        put("subcate57_159", "飞利浦");
        put("subcate57_750", "格力");
        put("subcate57_55542", "征服");
        put("subcate57_55532", "柔宇");
        put("subcate57_33080", "HTC");
        put("subcate57_49202", "8848");
        put("subcate57_300", "夏普");
        put("subcate57_221", "海尔");
        put("subcate57_52789", "雷鸟");
        put("subcate57_32729", "天语");
        put("subcate57_1081", "纽曼");
        put("subcate57_53520", "克里特");
        put("subcate57_54920", "传音");
        put("subcate57_34023", "酷比");
        put("subcate57_33855", "朵唯");
        put("subcate57_53979", "创星");
        put("subcate57_35179", "美图");
        put("subcate57_32570", "索爱");
        put("subcate57_53005", "詹姆士");
        put("subcate57_35849", "锤子科技");
        put("subcate57_57944", "360OS奇少年");
        put("subcate57_41933", "百合");
        put("subcate57_171", "TCL");
        put("subcate57_1589", "长虹");
        put("subcate57_35228", "21克");
        put("subcate57_36792", "索野");
        put("subcate57_53640", "ioutdoor");
        put("subcate57_35333", "欧奇");
        put("subcate57_52848", "守护宝");
        put("subcate57_599", "康佳");
        put("subcate57_355", "波导");
        put("subcate57_41148", "大松");
        put("subcate57_57930", "IPRO");
        put("subcate57_58347", "VIKK");
        put("subcate57_57491", "DOOGEE");
        put("subcate57_35102", "尼凯恩");
        put("subcate57_41365", "易百年");
        put("subcate57_35405", "誉品");
        put("subcate57_56216", "Librem");
        put("subcate57_35224", "SUGAR");
        put("subcate57_283", "富士通");
        put("subcate57_35121", "MANN");
        put("subcate57_34906", "邦华");
    }};

    @Override
    public void process(Page page) {
        //列表页
        if (page.getUrl().regex(URL_LIST).match()) {
            List<String> list = page.getHtml().xpath("//ul[@id='J_PicMode']/li").all();
            if (list.size() > 0) {
                List<String> urlList = new ArrayList<>();
                for (String s : list) {
                    String[] arr = s.split("comment-num");
                    try {
                        String url = arr[1].split("review.shtml")[0].split("href=\"")[1];

                        String productId = url.split("\\/")[2];
                        String listUrl = page.getUrl().get();

                        ZolResult zolResult = new ZolResult();
                        zolResult.setProductId(productId);
                        zolResult.setListUrl(listUrl);
                        for (Map.Entry<String, String> entry : brand.entrySet()) {
                            if (page.getUrl().get().contains(entry.getKey())) {
                                zolResult.setBrand(entry.getValue());
                            }
                        }
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
            String title = page.getHtml().xpath("//h1[@class='product-model__name']/text()").get();

            List<String> list = page.getHtml().xpath("//div[@class='detailed-parameters']/table").all();

            String onlineDate = null;
            String ram = null;
            String rom = null;
            String price = null;

            if (list.size() > 0) {
                for (String param : list) {
                    //上市时间
                    if (onlineDate == null) {
                        onlineDate = ParamParse.parseOnlineDate(param);
                    }
                    //RAM
                    if (ram == null) {
                        ram = ParamParse.parseRam(param);
                    }
                    //ROM
                    if (rom == null) {
                        rom = ParamParse.parseRom(param);
                    }
                    //price
                    if (price == null) {
                        price = ParamParse.parsePrice(param);
                    }
                }
            }
            ZolResult zolResult = zolResultMap.get(productId);
            if (zolResult == null) {
                System.out.println("======zolResult is nulll========");
            } else {
                zolResult.setParamUrl(contentUrl);
                title = title.split("\\（")[0];
                zolResult.setTitle(title);
                zolResult.setSeries(ParamParse.parseSeries(title));
                zolResult.setRam(ram);
                zolResult.setRom(rom);
                zolResult.setPrice(price);
                zolResult.setOnlineDate(onlineDate);
                zolResultMap.put(productId, zolResult);
                page.putField(productId, zolResult);
            }
        }
    }

    @Override
    public Site getSite() {
        return site;
    }
}
