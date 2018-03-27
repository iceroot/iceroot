package com.icexxx.util;

import java.util.Arrays;
import java.util.List;

/**
 * 分页实体类，封装了分页需要的属性
 * 
 * @author IceWater
 * @version 1.0
 */
public class IcePage<T> {
    private Integer first = 1;// 第一页
    private Integer last;// 最后一页
    private Integer prev;// 上一页
    private Integer next;// 下一页
    private Integer pageSize;// 每页条数
    private Integer itemCount;// 所有页总条数
    private int[] rainbow;// 分页条
    private List<T> list;// 当前页对象集合

    public Integer getFirst() {
        return first;
    }

    public void setFirst(Integer first) {
        this.first = first;
    }

    public Integer getLast() {
        return last;
    }

    public void setLast(Integer last) {
        this.last = last;
    }

    public Integer getPrev() {
        return prev;
    }

    public void setPrev(Integer prev) {
        this.prev = prev;
    }

    public Integer getNext() {
        return next;
    }

    public void setNext(Integer next) {
        this.next = next;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int[] getRainbow() {
        return rainbow;
    }

    public void setRainbow(int[] rainbow) {
        this.rainbow = rainbow;
    }

    @Override
    public String toString() {
        return "IcePage [first=" + first + ", last=" + last + ", prev=" + prev + ", next=" + next + ", pageSize="
                + pageSize + ", itemCount=" + itemCount + ", rainbow=" + Arrays.toString(rainbow) + ", list=" + list
                + "]";
    }

}
