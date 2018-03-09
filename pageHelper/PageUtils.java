package cn.antiy.weiqing.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author miaoying
 * @date 2/10/18
 */
public class PageUtils<T> {

    public PageEntity<T> paging(int pageIndex, int pageCapacity, List<T> data) {
        boolean isFirstPage = false;
        boolean isLastPage = false;
        boolean hasPreviousPage = false;
        boolean hasNextPage = false;
        List<T> list = new ArrayList<>();

        int total = data.size();
        int pageSize = (int) Math.ceil(total * 1.0 / pageCapacity);
        if (pageSize > 0 && pageIndex > 0) {
            if (pageIndex == 1) {
                isFirstPage = true;
                hasNextPage = true;
            }
            if (pageIndex == pageSize) {
                isLastPage = true;
                hasPreviousPage = true;
            }
            if (pageIndex > 1 && pageIndex < pageSize) {
                hasPreviousPage = true;
                hasNextPage = true;
            }
            if (pageIndex <= pageSize) {
                int min = pageCapacity * (pageIndex - 1);
                int max = pageCapacity * pageIndex;
                if (max >= total) {
                    max = total;
                }
                for (int i = min; i < max; i++) {
                    list.add(data.get(i));
                }
            }
        }
        PageEntity<T> pageInfo = new PageEntity<>(list, isFirstPage, isLastPage, hasPreviousPage, hasNextPage, pageSize, pageCapacity, pageIndex, total);
        return pageInfo;
    }

    public static void main(String[] args) {

    }
}
