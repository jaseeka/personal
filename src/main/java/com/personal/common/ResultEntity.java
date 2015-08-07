package com.personal.common;


import java.util.HashMap;
import java.util.Map;

/**
 * 结果集
 * Created by jaseeka
 * date 2015/7/26
 * time 16:42
 */
public class ResultEntity {

    /**
     * 返回状态码
     */
    private int code;

    /**
     * 返回消息
     */
    private String msg;

    /**
     * 返回数据
     */
    private Map<String, Object> data = new HashMap<String, Object>();

    /**
     * 分页信息
     */
    private Page page;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Page getPage() {
        return page;
    }
}
