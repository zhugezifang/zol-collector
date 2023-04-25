package org.example.processor;

import org.example.domain.ZolResult;
import org.example.pipeline.ConsolePipeline;
import org.example.utils.CnmoParamParse;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
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


//浏览器 cookie 网页打开是复制请求头中的cookie
public class WeiboPageProcessor implements PageProcessor {

    private Site site = Site.me()
            .addHeader("authority", "weibo.com")
            .addHeader("x-requested-with", "XMLHttpRequest")
            .addHeader("sec-ch-ua-mobile", "?0")
            .addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36")
            .addHeader("content-type", "application/x-www-form-urlencoded")
            .addHeader("accept", "*/*").addHeader("sec-fetch-site", "same-origin")
            .addHeader("sec-fetch-mode", "cors")
            .addHeader("sec-fetch-dest", "empty")
            .addHeader("referer", "https://weibo.com/1192329374/KnnG78Yf3?filter=hot&root_comment_id=0&type=comment")
            .addHeader("accept-language", "zh-CN,zh;q=0.9,en-CN;q=0.8,en;q=0.7,es-MX;q=0.6,es;q=0.5")
            //.addHeader("cookie", "SINAGLOBAL=9037630381998.047.1676553819772; UOR=,,www.bing.com; ULV=1681275444057:3:2:1:6755509146698.588.1681275444049:1680840418071; SCF=AoLdGjpfPMiG6koJOXeULk-exrRYH9CtLZG4aJGoUXMuwphrwJpov2c8S_5EcqsJ8pPucYv2MMZ4l8Su1JtWozQ.; XSRF-TOKEN=i0Pl37RdmLXK4W6O3INXuf8t; SUBP=0033WrSXqPxfM72wWs9jqgMF55529P9D9WFsFqXyZzzKHKlJ8ZdeMRxI5JpV8PyDqgvpIP-Eeh2NUNL5eKq0TJSadBtt; SUB=_2AkMTG9K5dcPxrAVQnf0cyGviZIRH-jygzrtPAn7uJhMyAxhq7gspqSVutBF-XIZfRaGGPx1vubux0Fno-WIdP1mU; WBPSESS=Dt2hbAUaXfkVprjyrAZT_Or2P4Gy3q5BO1Fvj6gYMaeeim4MwdeDOxywOyMotYeMTTauTNQ4X4LmTciOillVpY0lWLhyA6aZ-TpZXf7BeUCqZF2rR1aXsVyZEqBWC_XEjzE9CiFA43CIrSli6Jr3Uw==");
            .addHeader("cookie","SINAGLOBAL=9037630381998.047.1676553819772; UOR=,,www.bing.com; XSRF-TOKEN=i0Pl37RdmLXK4W6O3INXuf8t; _s_tentry=weibo.com; Apache=8835195744286.818.1682421438687; ULV=1682421438706:4:3:1:8835195744286.818.1682421438687:1681275444057; PC_TOKEN=d0402ac63d; SCF=AoLdGjpfPMiG6koJOXeULk-exrRYH9CtLZG4aJGoUXMuWJ38D1cHeWI2jDgOImpgbT4TYIyV3GhDT_oZ-pWV-9Q.; SUB=_2A25JQ8pNDeRhGeBP7lcY9C7MwzWIHXVqOLyFrDV8PUNbmtAGLXfkkW9NRSzNwxfc3aAMXoUM4PGbzUl05k6_NkN7; SUBP=0033WrSXqPxfM725Ws9jqgMF55529P9D9WFsFqXyZzzKHKlJ8ZdeMRxI5JpX5KzhUgL.FoqpSK-4Sh571h.2dJLoIEBLxKnLB-qLBonLxKnL1K2L1-zLxK-LB-BL1K5LxKqL1hnLB.qt; ALF=1713958300; SSOLoginState=1682422300; WBPSESS=Dt2hbAUaXfkVprjyrAZT_Or2P4Gy3q5BO1Fvj6gYMacQq7a3Nfd-NkwYtgLxgtT6fn_uKkna8taAJ5v6G37jKFi1-MsE2Mcb1jg2sNO-FgaMhwKXf7huIuqNc1Ue4TiNwTvE3VD-0YQvzJcU5Isyyrx_co6FeqGZ-Y4ilFfI8MOooThx5QDk3TPTRUkKu5e6FlPGefQV40BYUOK8GVU3KA==");

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
        //String url = "https://weibo.com/ajax/profile/info?custom=huangxiaoming";
        String url="https://weibo.com/ajax/friendships/friends?page=1&uid=1342715000";
        Spider.create(new WeiboPageProcessor()).addUrl(url).run();
    }

    /**
     *
     (1)ajax cookie
     (2)login cookie
     *
     */
}
