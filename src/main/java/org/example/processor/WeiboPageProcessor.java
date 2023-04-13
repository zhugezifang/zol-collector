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
 *
 * https://weibo.com/ajax/profile/info?custom=huangxiaoming  --某个用户(根据名称查询)
 *
 * https://weibo.com/ajax/profile/info?uid=1730077315  --某个用户(根据id查询)
 *
 * https://weibo.com/ajax/friendships/friends?relate=fans&page=1&uid=1730077315&type=all&newFollowerCount=0  用户的粉丝
 *
 * https://weibo.com/ajax/friendships/friends?page=1&uid=1730077315 用户 关注的人
 */

public class WeiboPageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);

    @Override
    public void process(Page page) {


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
        Spider.create(new WeiboPageProcessor()).addUrl(urls).addPipeline(new ConsolePipeline()).thread(baseUrls.length).run();
    }
}
