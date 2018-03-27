package com.icexxx.util;

/**
 * IceTree原始数据类型
 * 
 * @author IceWater
 * @version 2.1
 * @param <T> 泛型
 */
public class TableUseInTree<T> {
    private String id;
    private String parentId;
    private T obj;

    public TableUseInTree() {

    }

    public TableUseInTree(String id, String parentId, T obj) {
        this.id = id;
        this.parentId = parentId;
        this.obj = obj;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((obj == null) ? 0 : obj.hashCode());
        result = prime * result + ((parentId == null) ? 0 : parentId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TableUseInTree other = (TableUseInTree) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (this.obj == null) {
            if (other.obj != null)
                return false;
        } else if (!this.obj.equals(other.obj))
            return false;
        if (parentId == null) {
            if (other.parentId != null)
                return false;
        } else if (!parentId.equals(other.parentId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TableUseInTree [id=" + id + ", parentId=" + parentId + ", obj=" + obj + "]";
    }

}
