package com.personal.common;

/**
 * 状态枚举
 * Created by jaseeka
 * date 2015/7/26
 * time 16:42
 */
public abstract class TypeEnum {

    /**
     * 语言类型
     * 0.中文    1. 英文
     */
    public enum LanguageEnum{
        CN, EN
    }

    /**
     * 任务状态
     * 0：正常   1：已完成   2：放弃
     */
    public enum ItemState{
        NORMAL, DONE, ABANDON
    }
}
