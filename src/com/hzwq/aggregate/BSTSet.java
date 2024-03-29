package com.hzwq.aggregate;

import com.hzwq.tree.banirySTree.BST;

/**
 * 基于二分搜索树的集合类
 * @param <E> 继承了Comparable的对象
 */
public class  BSTSet <E extends Comparable<E>> implements Set<E> {

    private BST<E> bst;

    public BSTSet() {
        this.bst = new BST<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
