package com.icexxx.util;

import java.util.List;

public class IceTable {
    private String tableName;
    private List<IceColumn> columnList;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<IceColumn> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<IceColumn> columnList) {
        this.columnList = columnList;
    }

    @Override
    public String toString() {
        return "IceTable [tableName=" + tableName + ", columnList=" + columnList + "]";
    }

}
