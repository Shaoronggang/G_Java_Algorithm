package com.hzwq.aggregate;

// set 集合，向其中添加元素时，不能重复，所以底层实现最好使用二分搜索树
public interface Set<E> {
    /**
     * 添加元素
     * @param e
     */
     void add(E e);

    /**
     * 删除元素
     * @param e
     */
    void remove(E e);

    /**
     * 判断是否包含相应元素
     * @param e
     * @return
     */
    boolean contains(E e);

    /**
     * 获取集合长度
     * @return 返回集合长度
     */
    int getSize();

    /**
     * 判断是否为空
     * @return
     */
    boolean isEmpty();

}
