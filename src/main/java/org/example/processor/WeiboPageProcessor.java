package org.example.processor;

import org.example.domain.ZolResult;
import org.example.pipeline.ConsolePipeline;
import org.example.utils.CnmoParamParse;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * weibo爬虫
 * <p>
 * https://weibo.com/ajax/profile/info?custom=huangxiaoming  --某个用户(根据名称查询)
 * <p>
 * https://weibo.com/ajax/profile/info?uid=1730077315  --某个用户(根据id查询)
 * <p>
 * https://weibo.com/ajax/friendships/friends?relate=fans&page=1&uid=1730077315&type=all&newFollowerCount=0  用户的粉丝
 * <p>
 * https://weibo.com/ajax/friendships/friends?page=1&uid=1730077315 用户 关注的人
 */

public class WeiboPageProcessor implements PageProcessor {

    private Site site = Site.me().addHeader("authority", "weibo.com")
            .addHeader("x-requested-with", "XMLHttpRequest")
            .addHeader("sec-ch-ua-mobile", "?0")
            .addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36")
            .addHeader("content-type", "application/x-www-form-urlencoded")
            .addHeader("accept", "*/*")
            .addHeader("sec-fetch-site", "same-origin")
            .addHeader("sec-fetch-mode", "cors")
            .addHeader("sec-fetch-dest", "empty")
            .addHeader("referer", "https://weibo.com/1192329374/KnnG78Yf3?filter=hot&root_comment_id=0&type=comment")
            .addHeader("accept-language", "zh-CN,zh;q=0.9,en-CN;q=0.8,en;q=0.7,es-MX;q=0.6,es;q=0.5")
            .addHeader("cookie", "介里，患曲奇");


    @Override
    public void process(Page page) {
        System.out.println(page.getJson());
        //System.out.println("===============");
        //System.out.println(page.getHtml());
    }


    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        String url = "https://weibo.com/ajax/profile/info?custom=huangxiaoming";
        Spider.create(new WeiboPageProcessor()).addUrl(url).run();
    }
}
