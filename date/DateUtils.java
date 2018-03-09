package cn.antiy.weiqing.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zhanliquan on 17-6-7.
 * Description:
 */
public class DateUtils {
    public static Calendar getLastMonth(int lastMonth) {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY) - lastMonth, 1, 0, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal;
    }

    public static Date getBeforeMonthAtFirstDay(int lastMonth) {
        return getLastMonth(lastMonth).getTime();
    }

    public static Date getBeforeMonthAtLastDay(int lastMonth) {
        Calendar cal = getLastMonth(lastMonth);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 24);
        cal.set(Calendar.MILLISECOND, -1);
        return cal.getTime();
    }

    public static String getWeekDayZh(int weekDay) {
        if (Calendar.MONDAY == weekDay) {
            return "周一";
        } else if (Calendar.TUESDAY == weekDay) {
            return "周二";
        } else if (Calendar.WEDNESDAY == weekDay) {
            return "周三";
        } else if (Calendar.THURSDAY == weekDay) {
            return "周四";
        } else if (Calendar.FRIDAY == weekDay) {
            return "周五";
        } else if (Calendar.SATURDAY == weekDay) {
            return "周六";
        } else {
            return "周日";
        }
    }

    private static int DAY_MILL = 86400000; //24 * 60 * 60 * 1000;
    private static int MONTH_DAY = 30; // 30 day
    private static int YEAR_MONTH = 12; // 30 day

    public static int getIntervalDays(Date fDate, Date oDate) {
        if (null == fDate || null == oDate) {
            return -1;
        }
        long intervalMilli = oDate.getTime() - fDate.getTime();
        return (int) (intervalMilli / DAY_MILL);
    }

    public static int getIntervalMonths(Date fDate, Date oDate) {
        return getIntervalDays(fDate, oDate) / MONTH_DAY;
    }

    public static int getIntervalYears(Date fDate, Date oDate) {
        return getIntervalMonths(fDate, oDate) / YEAR_MONTH;
    }

    public static String dateFormat(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static Date parseDate(String date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static long getRefreshTimeout() {
        Calendar calendar = Calendar.getInstance();

        System.out.println("nowTime: " + dateFormat(calendar.getTime(), "YYYY-MM-dd HH:mm:ss"));
        int nowHour = calendar.get(Calendar.HOUR_OF_DAY);
        if (nowHour >= 2) calendar.add(Calendar.DAY_OF_YEAR, 1);

        calendar.set(Calendar.HOUR_OF_DAY, 2);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        System.out.println("refreshTime: " + dateFormat(calendar.getTime(), "YYYY-MM-dd HH:mm:ss"));
        return calendar.getTimeInMillis() - new Date().getTime();
    }

    public static String parseSwVersionUtcToFormatString(String utc, String format) {

        if (StringUtils.isEmpty(utc) || StringUtils.isEmpty(format)) return utc;
        try {
            long utcTimeStamp = Long.parseLong(utc);
            // 软件版本里面的utc是秒, 而不是毫秒, 这里需要×1000
            Date date = new Date(utcTimeStamp * 1000);
            return dateFormat(date, format);
        } catch (NumberFormatException e) {
            return utc;
        }
    }

    public static int getYearFromDate(Date date) {
        if (date != null) {
            Calendar calender = Calendar.getInstance();
            calender.setTime(date);
            return calender.get(Calendar.YEAR);
        }
        return 1979;
    }
}
