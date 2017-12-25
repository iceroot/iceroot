package com.icexxx.util;

public class IceTree {
    private String id;
    private String name;
    private Object obj;
    private IceTree tree;

    public IceTree() {
    }

    public IceTree(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public IceTree(String id, String name, Object obj) {
        this.id = id;
        this.name = name;
        this.obj = obj;
    }

    public IceTree(String id, String name, IceTree tree) {
        this.id = id;
        this.name = name;
        this.tree = tree;
    }

    public IceTree(String id, String name, Object obj, IceTree tree) {
        this.id = id;
        this.name = name;
        this.obj = obj;
        this.tree = tree;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public IceTree getTree() {
        return tree;
    }

    public void setTree(IceTree tree) {
        this.tree = tree;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((obj == null) ? 0 : obj.hashCode());
        result = prime * result + ((tree == null) ? 0 : tree.hashCode());
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
        IceTree other = (IceTree) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (this.obj == null) {
            if (other.obj != null)
                return false;
        } else if (!this.obj.equals(other.obj))
            return false;
        if (tree == null) {
            if (other.tree != null)
                return false;
        } else if (!tree.equals(other.tree))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "IceTree [id=" + id + ", name=" + name + ", obj=" + obj + ", tree=" + tree + "]";
    }
}
