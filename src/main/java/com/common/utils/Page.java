package com.common.utils;

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
    private Integer no = 1;
    /**
     * 一页记录数
     */
    private Integer size = Integer.MAX_VALUE - 1;
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

    public Page(Integer no, Integer size) {
        setNo(no);
        setSize(size);
    }

    public Page(Integer no, Integer size, String sort, String order) {
        setNo(no);
        setSize(size);
        setSort(sort);
        setOrder(order);
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
        this.totalPages = getTotalPages();
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getNo() {
        return no;
    }

    public Integer getSize() {
        return size;
    }

    public Integer getTotalRows() {
        return totalRows;
    }

    public Integer getTotalPages() {
        return totalRows % size == 0 ? totalRows / size : totalRows / size + 1;
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
        if (this.no == null || this.no <= 0)
            setNo(1);
        if (this.size == null || this.size <= 0)
            setSize(Integer.MAX_VALUE - 1);

        if (StringUtils.isEmpty(this.sort)) {
            return new PageBounds(this.no, this.size);
        } else {
            return new PageBounds(this.no, this.size, Order.create(getSort(), getOrder()));
        }
    }
}
