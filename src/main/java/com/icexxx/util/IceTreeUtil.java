package com.icexxx.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 树结构的相关操作
 * 
 * @author IceWater
 * @version 2.1
 */
public class IceTreeUtil {
    /**
     * 二维表转换为树形结构
     * 
     * @param tableList 原始二维表
     * @param <T> 泛型
     * @return 生成的结果树
     * @since 2.1
     */
    public static <T> IceTree tree(List<TableUseInTree<T>> tableList) {
        Map<String, IceTree> map = new HashMap<String, IceTree>();
        IceTree root = null;
        String idRoot = null;
        if (tableList == null || tableList.isEmpty()) {
            return null;
        }
        if (tableList.size() == 1) {
            TableUseInTree<T> table = tableList.get(0);
            IceTree tree = new IceTree();
            String id = table.getId();
            Object obj = table.getObj();
            tree.setId(id);
            tree.setObj(obj);
            return tree;
        }
        Set<String> ids = new HashSet<String>();
        for (int i = 0; i < tableList.size(); i++) {
            TableUseInTree<T> tableUseInTree = tableList.get(i);
            String id = tableUseInTree.getId();
            String parentId = tableUseInTree.getParentId();
            Object obj = tableUseInTree.getObj();
            IceTree tree = new IceTree();
            tree.setId(id);
            tree.setObj(obj);
            ids.add(id);
            map.put(id, tree);
            if (parentId == null || "".equals(parentId)) {
                idRoot = id;
                root = tree;
            }
        }
        for (int i = 0; i < tableList.size(); i++) {
            TableUseInTree<T> tableUseInTree = tableList.get(i);
            String id = tableUseInTree.getId();
            String parentId = tableUseInTree.getParentId();
            T obj = tableUseInTree.getObj();
            if (root == null) {
                if (!ids.contains(parentId)) {
                    IceTree tree = new IceTree();
                    tree.setId(id);
                    tree.setObj(obj);
                    root = tree;
                    idRoot = id;
                }
            }
            IceTree childTree = map.get(id);
            IceTree parentTree = map.get(parentId);
            if (parentTree != null) {
                List<IceTree> treeList = parentTree.getTree();
                if (treeList == null) {
                    treeList = new ArrayList<IceTree>();
                }
                parentTree.setTree(treeList);
                treeList.add(childTree);
            }
        }
        Set<Entry<String, IceTree>> entrySet = map.entrySet();
        Iterator<Entry<String, IceTree>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Entry<String, IceTree> entry = iterator.next();
            String key = entry.getKey();
            if (key.equals(idRoot)) {
                return entry.getValue();
            }
        }
        return null;
    }
}
