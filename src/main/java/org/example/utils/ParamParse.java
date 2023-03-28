package org.example.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ParamParse {

    private Map<String, String> brand = new HashMap<String, String>() {
        {
            put("iphone", "iphone数字系列");
            put("iphonese", "iPhone SE系列");
            put("iphonex", "iPhone X系列");
            put("iphonexs", "iPhone XS系列");
            put("iphonexr", "iPhone XR系列");
        }
    };

    public static String parseSeries(String title) {
        title = title.replaceAll(" ", "").toLowerCase(Locale.ROOT);
        if (title.equals("iphonexr")) {
            return "iPhone XR系列";
        } else if (title.equals("iphonexs")) {
            return "iPhone XS系列";
        } else if (title.equals("iphonese")) {
            return "iPhone SE系列";
        } else if (title.contains("iphone")) {
            return "iPhone数字系列";
        } else {
            return null;
        }
    }

    public static String parseOnlineDate(String str) {
        Document doc = Jsoup.parse(str);
        Elements trs = doc.select("table").select("tr");
        for (int i = 0; i < trs.size(); i++) {
            Elements ths = trs.get(i).select("th");
            Elements tds = trs.get(i).select("td");
            for (int j = 0; j < tds.size(); j++) {
                String title = "";
                if (ths.size() > 0) {
                    title = ths.get(j).text();
                }
                String text = tds.get(j).select("span").text();
                if (title.equals("上市日期")) {
                    String[] arr = text.split("月");
                    if (arr.length > 1) {
                        return arr[0] + "月";
                    } else {
                        return text.split(">")[0];
                    }
                }
            }
        }
        return null;
    }

    public static String parseRam(String str) {
        Document doc = Jsoup.parse(str);
        Elements trs = doc.select("table").select("tr");
        for (int i = 0; i < trs.size(); i++) {
            Elements ths = trs.get(i).select("th");
            Elements tds = trs.get(i).select("td");
            for (int j = 0; j < tds.size(); j++) {
                String title = "";
                if (ths.size() > 0) {
                    title = ths.get(j).text();
                }
                String text = tds.get(j).text();
                if (title.equals("RAM容量")) {
                    //System.out.println(title + ":" + text);
                    String[] arr = text.split("B");
                    if (arr.length > 1) {
                        return arr[0] + "B";
                    } else {
                        return text;
                    }
                }
            }
        }
        return null;
    }

    public static String parseRom(String str) {
        Document doc = Jsoup.parse(str);
        Elements trs = doc.select("table").select("tr");
        for (int i = 0; i < trs.size(); i++) {
            Elements ths = trs.get(i).select("th");
            Elements tds = trs.get(i).select("td");
            for (int j = 0; j < tds.size(); j++) {
                String title = "";
                if (ths.size() > 0) {
                    title = ths.get(j).text();
                }
                String text = tds.get(j).text();
                if (title.equals("ROM容量")) {
                    String[] arr = text.split("B");
                    if (arr.length > 1) {
                        return arr[0] + "B";
                    } else {
                        return text;
                    }
                }
            }
        }
        return null;
    }

    public static String parsePrice(String str) {
        Document doc = Jsoup.parse(str);
        Elements trs = doc.select("table").select("tr");
        for (int i = 0; i < trs.size(); i++) {
            Elements ths = trs.get(i).select("th");
            Elements tds = trs.get(i).select("td");
            for (int j = 0; j < tds.size(); j++) {
                String title = "";
                if (ths.size() > 0) {
                    title = ths.get(j).text();
                }
                String text = tds.get(j).text();
                if (title.equals("电商报价")) {
                    //System.out.println(title + ":" + text);
                    return text;
                }
            }
        }
        return null;
    }


}
