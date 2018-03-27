package com.icexxx.util;

/**
 * 分页工具类
 * 
 * @author IceWater
 * @version 2.0.0
 */
public class IcePageUtil {
    /**
     * 获取总页数和记录偏移量
     * 
     * @param countItem 条目总数
     * @param pageSize 每页记录数
     * @param pageIndex 当前页
     * @return 总页数和记录偏移量的包装对象
     */
    public IcePageWrap page(int countItem, int pageSize, int pageIndex) {
        if (pageIndex < 1) {
            pageIndex = 1;
        }
        IcePageWrap pageWrap = new IcePageWrap();
        int countPage = countItem / pageSize;
        if (countItem % pageSize != 0) {
            countPage++;
        }
        if (pageIndex > countPage) {
            pageIndex = countPage;
        }
        int offset = (pageIndex - 1) * pageSize;
        pageWrap.setCount(countPage);
        pageWrap.setOffset(offset);
        return pageWrap;
    }
}
