package cn.antiy.weiqing.utils;

import java.util.List;

/**
 * Created by zhanliquan on 17-8-21.
 * Description:
 */
public class Validator {

    public static boolean isNotNull(Long l) {
        return !isNull(l);
    }

    public static boolean isNotNull(String s) {
        return !isNull(s);
    }

    public static boolean isNotNull(List list) {
        return !isNull(list);

    }

    public static boolean isNotNull(Object o) {
        return !isNull(o);
    }

    public static boolean isNull(Object obj) {
        if (obj instanceof Long) {
            return isNull((Long) obj);
        } else if (obj instanceof String) {
            return isNull((String) obj);
        } else if (obj == null) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNull(Long l) {
        if ((l == null) || l.longValue() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNull(String s) {
        if (s == null) {
            return true;
        }

        s = s.trim();

        if ((s.equals(StringPool.EMPTY))) {
            return true;
        }

        return false;
    }

    public static boolean isNull(List list) {
        if ((list == null) || (list.size() == 0)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNull(Object[] array) {
        if ((array == null) || (array.length == 0)) {
            return true;
        } else {
            return false;
        }
    }
}
