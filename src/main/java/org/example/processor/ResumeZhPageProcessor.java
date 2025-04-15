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

    public static final String URL_LIST = "list";

    public static final String URL_CONTENT = "html";

    public static final String content_url = "https://www.jianlimoban-ziyuan.com{}";

    private Map<String, Resume> resumeMap = new HashMap<>();

    @Override
    public void process(Page page) {
        //列表页
        if (page.getUrl().regex(URL_LIST).match()) {

            List<String> list = page.getHtml().xpath("//div[@class='jlmblist']").all();
            
            if (list.size() > 0) {
                List<String> urlList = new ArrayList<>();
                for (String s : list) {
                    List<String> cvList= new Html(s).xpath("//div[@class='jlmbpre']").all();
                    Selectable selectable= new Html(cvList.get(0));
                    String href= "https://www.51386.com"+selectable.xpath("//a/@href").get();

                    String title= selectable.xpath("//a/@title").get();
                    String imgUrl= "https:"+selectable.xpath("//a//img/@src").get();
                    if (imgUrl.equals("https:")){
                        imgUrl= "https:"+selectable.xpath("//a//img/@data-original").get();
                    }
                    String[] array = href.split("/");
                    String id = array[array.length-1].split("\\.")[0];
                    if (title.equals("")){
                        break;
                    }
                    System.out.println("==========");
                    System.out.println(id+":"+title+":"+imgUrl+":"+href);
                    Resume resume=new Resume();
                    resume.setTitle(title);
                    resume.setImgUrl(imgUrl);
                    resume.setId(id);
                    resumeMap.put(id,resume);
                    urlList.add(href);
                }
                page.addTargetRequests(urlList);
            }

        }else {
            List<String> list = page.getHtml().xpath("//p[@class='imgview']").all();
            String[] str = page.getUrl().get().split("\\/");
            String id= str[str.length-1].split("\\.")[0];

            if (list.size() > 0) {
                List<String> contentImgList = new ArrayList<>();
                for (String s : list) {
                    String contentImgUrl= "https:"+ new Html(s).xpath("//p//img/@src").get();
                    contentImgList.add(contentImgUrl);
                }
                String downloadUrl = page.getHtml().xpath("//a[@class='dbpandown']/@href").get();
                Resume resume = resumeMap.get(id);
                resume.setContentImgUrl(String.join(";",contentImgList));
                resume.setDownloadUrl(downloadUrl);
                page.putField(id, resume);
            }
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        //String url="https://www.jianlimoban-ziyuan.com/duoye/748.html";
        String url = "https://www.51386.com/jlmb/listxx.html";
        String[] baseUrls = new String[14];
        for(int i=0;i<14;i++){
            baseUrls[i]=url.replaceAll("xx",(i+1)+"");
        }
        Spider.create(new ResumeZhPageProcessor()).addUrl(baseUrls).addPipeline(new ResumeConsolePipeline()).run();
    }
}
