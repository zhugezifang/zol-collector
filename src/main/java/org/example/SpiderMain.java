package org.example;

import org.example.pipeline.ConsolePipeline;
import org.example.processor.ZoLPageProcessor;
import us.codecraft.webmagic.Spider;

public class SpiderMain {
    public static void main(String[] args) {

        String[] baseUrls = new String[]{
                "http://detail.zol.com.cn/cell_phone_index/subcate57_613_list_${i}.html"};

        /*String[] baseUrls = new String[]{
                "http://detail.zol.com.cn/cell_phone_index/subcate57_613_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_544_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_49202_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_35224_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_36511_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_33626_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_159_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_51558_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_1081_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_52848_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_37323_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_34906_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_53640_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_41365_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_33855_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_355_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_50840_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_36409_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_34275_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_54243_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_35179_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_297_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_53765_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_227_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_143_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_531_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_41373_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_1763_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_221_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_55731_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_1069_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_34857_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_98_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_171_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_35102_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_37427_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_35849_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_56290_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_53521_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_34645_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_34023_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_35579_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_53979_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_32729_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_1795_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_33668_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_52602_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_49531_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_35333_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_1434_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_32570_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_52034_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_36792_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_55893_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_750_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_19_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_295_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_35350_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_642_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_55532_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_55542_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_41933_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_300_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_12772_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_36647_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_1606_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_35121_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_55535_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_1673_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_56216_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_41412_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_35615_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_53006_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_54920_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_33080_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_34492_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_34660_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_1590_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_35405_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_40737_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_54909_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_364_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_53520_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_35320_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_1922_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_37319_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_544_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_1589_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_53005_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_1632_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_35005_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_35228_list_${i}.html",
                "http://detail.zol.com.cn/cell_phone_index/subcate57_599_list_${i}.html"
        };*/
        String[] urls = new String[10 * baseUrls.length];
        int num = 0;
        for (int i = 0; i < baseUrls.length; i++) {
            for (int j = 0; j < 10; j++) {
                String str = baseUrls[i].replace("${i}", (j + 1) + "");
                urls[num] = str;
                num++;
            }
        }
        Spider.create(new ZoLPageProcessor()).addUrl(urls).addPipeline(new ConsolePipeline()).thread(baseUrls.length).run();
    }
}
