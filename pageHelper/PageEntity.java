package cn.antiy.weiqing.utils;

import lombok.Data;

import java.util.List;

/**
 * @author miaoying
 * @date 2/10/18
 */
@Data
public class PageEntity<T> {
    /**
     * 返回的结果集
     */
    private List<T> list;
    /**
     * 是否是第一页
     */
    private Boolean isFirstPage;
    /**
     * 是否是最后一页
     */
    private Boolean isLastPage;
    /**
     * 是否有上一页
     */
    private Boolean hasPreviousPage;
    /**
     * 是否有下一页
     */
    private Boolean hasNextPage;
    /**
     * 总页数
     */
    private Integer pageSize;
    /**
     * 页容量
     */
    private Integer pageCapacity;
    /**
     * 当前页码
     */
    private Integer pageIndex;
    /**
     * 记录总条数
     */
    private Integer total;

    public PageEntity() {
    }

    public PageEntity(List<T> list, Boolean isFirstPage, Boolean isLastPage, Boolean hasPreviousPage, Boolean hasNextPage, Integer pageSize, Integer pageCapacity, Integer pageIndex, Integer total) {
        this.list = list;
        this.isFirstPage = isFirstPage;
        this.isLastPage = isLastPage;
        this.hasPreviousPage = hasPreviousPage;
        this.hasNextPage = hasNextPage;
        this.pageSize = pageSize;
        this.pageCapacity = pageCapacity;
        this.pageIndex = pageIndex;
        this.total = total;
    }
}
