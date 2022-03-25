package com.wangyi.wyhomework.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalculateTime {

    // private String time = "Sat Mar 19 15:48:24 +0800 2022";

    //计算显示时间
    public static String getShowTime(Date date) {
        Date originalDate = date;
        Date nowDate = new Date();
        String finalShowTime;
        long l = nowDate.getTime() - originalDate.getTime() ;
        //3.分别计算相差的天、小时、分、秒
        long day = l / (24 * 60 * 60 * 1000);
        long hour = (l / (60 * 60 * 1000) - day * 24);
        long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
        String monthAndDay = new SimpleDateFormat("M-d").format(date);
        String hourAndMin = new SimpleDateFormat("HH:mm").format(date);

        //时间显示的逻辑
        if (day > 0) {
            if (day > 1) {
                //example: 3-18
                finalShowTime = monthAndDay;
            } else {
                //example: 昨天 20:13
                finalShowTime = "昨天 " + hourAndMin;
            }
        } else {
            if (hour > 0) {
                //example: 3小时前
                finalShowTime = Long.toString(hour) + "小时前";
            } else {
                //example: 30分钟前
                if (min > 0) {
                    finalShowTime = Long.toString(min) + "分钟前";
                } else {
                    //example: 刚刚
                    finalShowTime = "刚刚";
                }

            }
        }
        return finalShowTime;
    }


}


