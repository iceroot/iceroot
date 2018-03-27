package com.icexxx.util;

/**
 * 数据库列对象
 * 
 * @author IceWater
 * @version 2.0
 */
public class IceColumn {
    private String columnName;
    private String columnLabel;
    private String columnTypeName;
    private int columnType;
    private int columnDisplaySize;
    private int columnCount;
    private int Scale;
    private String columnClassName;
    private String tableName;
    private String schemaName;
    private String catalogName;
    private int precision;
    private String remark;
    private boolean nullable;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnLabel() {
        return columnLabel;
    }

    public void setColumnLabel(String columnLabel) {
        this.columnLabel = columnLabel;
    }

    public String getColumnTypeName() {
        return columnTypeName;
    }

    public void setColumnTypeName(String columnTypeName) {
        this.columnTypeName = columnTypeName;
    }

    public int getColumnType() {
        return columnType;
    }

    public void setColumnType(int columnType) {
        this.columnType = columnType;
    }

    public int getColumnDisplaySize() {
        return columnDisplaySize;
    }

    public void setColumnDisplaySize(int columnDisplaySize) {
        this.columnDisplaySize = columnDisplaySize;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }

    public int getScale() {
        return Scale;
    }

    public void setScale(int scale) {
        Scale = scale;
    }

    public String getColumnClassName() {
        return columnClassName;
    }

    public void setColumnClassName(String columnClassName) {
        this.columnClassName = columnClassName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean getNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    @Override
    public String toString() {
        return "IceColumn [columnName=" + columnName + ", columnLabel=" + columnLabel + ", columnTypeName="
                + columnTypeName + ", columnType=" + columnType + ", columnDisplaySize=" + columnDisplaySize
                + ", columnCount=" + columnCount + ", Scale=" + Scale + ", columnClassName=" + columnClassName
                + ", tableName=" + tableName + ", schemaName=" + schemaName + ", catalogName=" + catalogName
                + ", precision=" + precision + ", remark=" + remark + ", nullable=" + nullable + "]";
    }

}
