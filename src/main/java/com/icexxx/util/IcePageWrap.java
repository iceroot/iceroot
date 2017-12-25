package com.icexxx.util;

/**
 * 分页记录总数偏移量包装体
 * 
 * @author IceWater
 * @version 2.0
 */
public class IcePageWrap {
    private int count;
    private int offset;

    public int getCount() {
        return count;
    }

    public int getOffset() {
        return offset;
    }

    void setCount(int count) {
        this.count = count;
    }

    void setOffset(int offset) {
        this.offset = offset;
    }
}
