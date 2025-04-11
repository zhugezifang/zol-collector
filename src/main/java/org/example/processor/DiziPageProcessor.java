package org.example.processor;

import org.example.domain.Dipu;
import org.example.domain.Resume;
import org.example.domain.ZolResult;
import org.example.pipeline.DipuConsolePipeline;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.*;

/**
 * cnmo手机爬虫
 */

public class DiziPageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);

    public static final String URL_LIST = "tag";

    public static final String URL_CONTENT = "jianpu";

    public static final String content_url = "https://www.jianlimoban-ziyuan.com{}";

    private Map<String, Dipu> resumeMap = new HashMap<>();

    @Override
    public void process(Page page) {
        String[] pageUrls=page.getUrl().get().split("\\/");
        //列表页
        if (pageUrls[pageUrls.length-1].indexOf(URL_LIST)>=0) {
            List<String> list = page.getHtml().xpath("//div[@class='like']//ul//li").all();
            if (list.size() > 0) {
                List<String> urlList = new ArrayList<>();
                for (String s : list) {
                    Selectable selectable= new Html(s).xpath("//li//a");

                    // 提取 <a> 标签的 href
                    String href = selectable.xpath("//a/@href").get();
                    //System.out.println("Href: " + href);

                    // 提取 <span> 里的文本（标题）
                    String title = selectable.xpath("//a/span/text()").get();
                    //System.out.println("Title: " + title);
                    String[] hrefs= href.split("\\/");
                    try {
                        String id = hrefs[hrefs.length-1].substring(0,hrefs[hrefs.length-1].indexOf("."));

                        Dipu resume = new Dipu();
                        resume.setId(id);
                        resume.setTitle(title);
                        resumeMap.put(id, resume);

                        //String url = content_url.replace("{}", downloadUrl);
                        urlList.add(href);
                    } catch (Exception e) {
                        //System.out.println(downloadUrl);
                        e.printStackTrace();
                    }
                }
                page.addTargetRequests(urlList);
            }
            //详细参数页
        } else if (page.getUrl().regex(URL_CONTENT).match()) {
            //String id = page.getUrl().get().split(".html")[0].split("\\/")[1];
            String[] str = page.getUrl().get().split("\\/");

            String id= str[str.length-1].split("\\.")[0];

            Dipu zolResult = resumeMap.get(id);

            String longTitle = page.getHtml().xpath("//div[@class='info']//h1/text()").get();
            List<String> imgList = page.getHtml().xpath("//div[@class='pic']//img").all();
            String imgUrl="";
            if (imgList.size() > 0) {
                List<String> imgUrlList = new ArrayList<>();
                for (String s : imgList) {
                    Selectable imgSelect= new Html(s);
                    // 提取 <a> 标签的 href
                    String img = imgSelect.xpath("//img/@src").get();
                    imgUrlList.add("http://www.dizijun.com"+img);
                }
                imgUrl= String.join(";",imgUrlList);
            }

            String desc = page.getHtml().xpath("//div[@class='explain']/text()").get();
            zolResult.setImgUrl(imgUrl);
            zolResult.setLongTitle(longTitle);
            zolResult.setDesc(desc);
            page.putField(id, zolResult);
            //System.out.println(page.getUrl()+" "+category+" "+downLoadUrl);

        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        //String url="https://www.jianlimoban-ziyuan.com/duoye/748.html";
        String[] baseUrls = new String[]{
                "http://www.dizijun.com/jianpu/tag_A.html"
                ,"http://www.dizijun.com/jianpu/tag_B.html"
                ,"http://www.dizijun.com/jianpu/tag_C.html"
                ,"http://www.dizijun.com/jianpu/tag_D.html"
                ,"http://www.dizijun.com/jianpu/tag_E.html"
                ,"http://www.dizijun.com/jianpu/tag_F.html"
                ,"http://www.dizijun.com/jianpu/tag_G.html"
                ,"http://www.dizijun.com/jianpu/tag_H.html"
                ,"http://www.dizijun.com/jianpu/tag_I.html"
                ,"http://www.dizijun.com/jianpu/tag_J.html"
                ,"http://www.dizijun.com/jianpu/tag_K.html"
                ,"http://www.dizijun.com/jianpu/tag_L.html"
                ,"http://www.dizijun.com/jianpu/tag_M.html"
                ,"http://www.dizijun.com/jianpu/tag_N.html"
                ,"http://www.dizijun.com/jianpu/tag_O.html"
                ,"http://www.dizijun.com/jianpu/tag_P.html"
                ,"http://www.dizijun.com/jianpu/tag_Q.html"
                ,"http://www.dizijun.com/jianpu/tag_R.html"
                ,"http://www.dizijun.com/jianpu/tag_S.html"
                ,"http://www.dizijun.com/jianpu/tag_T.html"
                ,"http://www.dizijun.com/jianpu/tag_U.html"
                ,"http://www.dizijun.com/jianpu/tag_V.html"
                ,"http://www.dizijun.com/jianpu/tag_W.html"
                ,"http://www.dizijun.com/jianpu/tag_X.html"
                ,"http://www.dizijun.com/jianpu/tag_Y.html"
                ,"http://www.dizijun.com/jianpu/tag_Z.html"};

        Spider.create(new DiziPageProcessor()).addUrl(baseUrls).addPipeline(new DipuConsolePipeline()).run();
    }
}
