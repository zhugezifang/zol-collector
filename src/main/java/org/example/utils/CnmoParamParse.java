package org.example.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class CnmoParamParse {

    public static String parsePrice(String str) {
        Document doc = Jsoup.parse(str);
        String price = doc.select("p").text().split(" ")[1];
        return price;
    }

    public static String parseOnlineDate(String str) {
        Document doc = Jsoup.parse(str);
        String onlineDate = doc.select("p").select("span").text();
        return onlineDate;
    }

    public static String parseRam(String str) {
        Document doc = Jsoup.parse(str);
        Elements trs = doc.select("li");
        for (int i = 0; i < trs.size(); i++) {
            Elements ths = trs.get(i).select("div");
            if (ths.get(0).text().equals("机身容量")) {
                //System.out.println(title + ":" + text);
                return ths.get(1).text().split(" ")[0];
            }
        }
        return null;
    }

    public static String parseRom(String str) {
        Document doc = Jsoup.parse(str);
        Elements trs = doc.select("li");
        for (int i = 0; i < trs.size(); i++) {
            Elements ths = trs.get(i).select("div");
            if (ths.get(0).text().equals("运行内存")) {
                //System.out.println(title + ":" + text);
                return ths.get(1).text().split(" ")[0];
            }
        }
        return null;
    }

}
