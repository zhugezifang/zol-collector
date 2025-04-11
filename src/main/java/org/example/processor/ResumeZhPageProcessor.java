package org.example.processor;

import org.example.domain.Resume;
import org.example.pipeline.ConsolePipeline;
import org.example.domain.ZolResult;
import org.example.pipeline.ResumeConsolePipeline;
import org.example.utils.CnmoParamParse;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * cnmo手机爬虫
 */

public class ResumeZhPageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);

    public static final String URL_LIST = "jianlimoban";

    public static final String URL_CONTENT = "html";

    public static final String content_url = "https://www.jianlimoban-ziyuan.com{}";

    private Map<String, Resume> resumeMap = new HashMap<>();

    @Override
    public void process(Page page) {
        //列表页
        if (page.getUrl().regex(URL_CONTENT).match()) {

            //String id = page.getUrl().get().split(".html")[0].split("\\/")[1];

            List<String> listA = page.getHtml().xpath("//div[@class='nav_box']/a").all();


            String category= new Html(listA.get(1)).css("a", "text").get();


            String downLoadUrl = page.getHtml().css("#download_btn a","href").get();

            System.out.println(page.getUrl()+" "+category+" "+downLoadUrl);

        }else if (page.getUrl().regex(URL_LIST).match()) {
            List<String> list = page.getHtml().xpath("//div[@class='mb_item']").all();
            if (list.size() > 0) {
                List<String> urlList = new ArrayList<>();
                for (String s : list) {
                    Selectable selectable= new Html(s).xpath("//div[@class='mb_item_box']");

                    String title = selectable.css(".title_box a", "text").get();
                    // 提取图片地址（需要补全协议）
                    String imageUrl = selectable.css(".img_box img", "src").get();
                    if (imageUrl != null && imageUrl.startsWith("//")) {
                        imageUrl = "https:" + imageUrl; // 补全为 HTTPS
                    }
                    // 提取下载地址
                    String downloadUrl = selectable.css(".down_right", "href").get();
                    System.out.println(title+","+imageUrl+":"+downloadUrl);
                    try {
                        String id = downloadUrl.split(".html")[0].split("/")[2];

                        Resume resume = new Resume();
                        resume.setId(id);
                        resume.setTitle(title);
                        resume.setImgUrl(imageUrl);
                        resumeMap.put(id, resume);

                        String url = content_url.replace("{}", downloadUrl);
                        urlList.add(url);
                    } catch (Exception e) {
                        System.out.println(downloadUrl);
                        e.printStackTrace();
                    }
                }
                page.addTargetRequests(urlList);
            }
            //详细参数页
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        //String url="https://www.jianlimoban-ziyuan.com/duoye/748.html";

        String[] baseUrls = new String[]{
                "https://www.51386.com/"
        };

        Spider.create(new ResumeZhPageProcessor()).addUrl(baseUrls).run();
    }
}
