package me.newtrekwang.baselibrary.utils;

import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @className DateUtils
 * @createDate 2018/7/15 23:38
 * @author newtrekWang
 * @email 408030208@qq.com
 * @desc 日期时间工具类
 *
 */
public final class DateUtils {
    private DateUtils(){
    }

   private static class DateUtilsHolder{
        private static final DateUtils INSTANCE = new DateUtils();
    }

    public static DateUtils getInstance(){
        return  DateUtilsHolder.INSTANCE;
    }
    /**
     * 英文简写（默认）如：12-01
     */
    private final String FORMAT_MONTH_DAY = "MM-dd";
    /**
     * 英文简写（默认）如：2010-12-01
     */
    private final String FORMAT_SHORT=  "yyyy-MM-dd";
    /**
     * 英文全称 如：2010-12-01 23:15:06
     */
    private final String FORMAT_DATE_PATTERN=  "yyyy-MM-dd HH:mm:ss";

    /**
     * 中文简写 如：12月01日 23:18
     */
    private final String FORMAT_SHORT_CN_MINI = "MM月dd日 HH:mm";

    /**
     * 中文简写 如：2010年12月01日
     */
    private final String FORMAT_SHORT_CN = "yyyy年MM月dd日";
    /**
     * 中文全称 如：2010年12月01日 23时15分06秒
     */
    private final String  FORMAT_LONG_CN = "yyyy年MM月dd日  HH时mm分ss秒";


    private final String TIMEZONE = "Asia/Shanghai";

    /**
     * 获取当前时间
     * @return
     */
    public String now(){
        return format(new Date());
    }


    /**
     * 使用用户格式格式化日期
     * @param date
     * @param pattern
     * @return
     */
    public String format(Date date,String pattern){
        String  result = "";
        if (date != null && !TextUtils.isEmpty(pattern)){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.CHINA);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(TIMEZONE));
            result = simpleDateFormat.format(date);
        }
        return result;

    }

    /**
     * 默认格式格式化日期
     * @param date
     * @return
     */
    public String format(Date date){
        String  result = "";
        if(date !=null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_DATE_PATTERN,Locale.CHINA);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(TIMEZONE));
            result = simpleDateFormat.format(date);
        }
        return  result;
    }

    /**
     * 使用用户格式提取字符串日期
     * @param strDate 日期字符串
     * @param pattern 日期格式
     * @return
     */
    public Date parse(String strDate,String pattern){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern,Locale.CHINA);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(TIMEZONE));
        try {
            return simpleDateFormat.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }







}
