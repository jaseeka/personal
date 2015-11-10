package com.common.utils;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具了
 * Created by jaseeka
 * date 2015/7/21
 * time 20:52
 */
public class DateUtils {

    /**
     * Date转字符串
     * @param date
     * @param formateStr
     * @return
     */
    public static String formateDate(Date date, String formateStr){

        DateFormat dateFormat = new SimpleDateFormat(formateStr);

        return dateFormat.format(date);
    }

    /**
     * 字符串转Date
     * @param dateStr
     * @param formateStr
     * @return
     */
    public static Date formateStr(String dateStr, String formateStr){

        DateFormat dateFormat = new SimpleDateFormat(formateStr);

        Date date = null;

        try {
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }


}
