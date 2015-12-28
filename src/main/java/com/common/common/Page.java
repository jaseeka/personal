package com.common.common;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.springframework.util.StringUtils;

/**
 * 分页条件对象
 * 如果分页对象为空时直接调用静态方法gianPageBoundsForNull返回分页对象ageBounds
 * 分页插件所需PageBounds都需要使用gain方法获取
 * Created by jaseeka on 2015/4/6.
 */
public class Page {
    /**
     * order DESC
     */
    public static final String ORDER_DESC = "DESC";

    /**
     * order ASC
     */
    public static final String ORDER_ASC = "ASC";

    /**
     * 当前页号
     */
    private Integer pageNo = 1;
    /**
     * 一页记录数
     */
    private Integer pageSize = Integer.MAX_VALUE - 1;
    /**
     * 总记录数
     */
    private Integer totalRows = 0;
    /**
     * 总页数
     */
    private Integer totalPages = 0;
    /**
     * 排序字段 为实体属性名
     */
    private String sort = "id";
    /**
     * 排序类型ASC升/DESC降 （为空默认ASC）
     */
    private String order = ORDER_ASC;

    public Page() {
    }

    public Page(Integer pageNo, Integer pageSize) {
        setPageNo(pageNo);
        setPageSize(pageSize);
    }

    public Page(Integer pageNo, Integer pageSize, String sort, String order) {
        setPageNo(pageNo);
        setPageSize(pageSize);
        setSort(sort);
        setOrder(order);
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
        this.totalPages = getTotalPages();
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getTotalRows() {
        return totalRows;
    }

    public Integer getTotalPages() {
        return totalRows % pageSize == 0 ? totalRows / pageSize : totalRows / pageSize + 1;
    }

    public String getSort() {
        return sort;
    }

    public String getOrder() {
        return order;
    }

    public void setSort(String sort) {
//        if (sort.contains("_"))
        this.sort = sort;
//        else
//            this.sort = ClassUtils.changeAttrToDatabase(sort);
    }

    public void setOrder(String order) {
        if (order != null && ORDER_DESC.equals(order.toUpperCase()))
            this.order = order;
        else
            this.order = ORDER_ASC;
    }

    /**
     * 分页对象为空时返回分页条件
     *
     * @return
     */
    public static PageBounds gainPageBoundsForNull() {
        return new PageBounds(0, Integer.MAX_VALUE - 1);
    }

    public PageBounds gainPageBounds() {
        if (this.pageNo == null || this.pageNo <= 0)
            setPageNo(1);
        if (this.pageSize == null || this.pageSize <= 0)
            setPageSize(Integer.MAX_VALUE - 1);

        if (StringUtils.isEmpty(this.sort)) {
            return new PageBounds(this.pageNo, this.pageSize);
        } else {
            return new PageBounds(this.pageNo, this.pageSize, Order.create(getSort(), getOrder()));
        }
    }
}
