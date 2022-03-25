package com.wangyi.wyhomework.utils;

import java.util.ArrayList;
import java.util.List;

public class ReplaceImageSize {


    public static ArrayList<String> replace(List<String> imgUrlList){
        ArrayList<String> newImageUrl = new ArrayList<>();
        for (int i = 0; i < imgUrlList.size(); i++) {
            newImageUrl.add(i,imgUrlList.get(i).replace("thumbnail", "bmiddle"));
        }
        return newImageUrl;
    }

}

