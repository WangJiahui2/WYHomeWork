package com.wangyi.wyhomework.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseHref {

    public static String parseHref(String source) {
        Pattern pattern = Pattern.compile("<a.*?href=[\"']?((https?://)?/?[^\"']+)[\"']?.*?>(.+)</a>");
        Matcher matcher = pattern.matcher(source);
        if (matcher.find()) {
            String link = matcher.group(1).trim();
            String title = matcher.group(3).trim();
//            if (!link.startsWith("http")) {
//                if (link.startsWith("/"))
//                    link = "http://www.zifangsky.cn" + link;
//                else
//                    link = "http://www.zifangsky.cn" + link;
//            }
            System.out.println("link: " + link);
            System.out.println("title: " + title);
//            return link + " " + title;
            return title;
        }
        return null;

    }
    
}