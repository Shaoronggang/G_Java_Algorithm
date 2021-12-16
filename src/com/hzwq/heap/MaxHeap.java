package com.hzwq.heap;

import com.hzwq.array.GoodArray;

/**
 * 基于动态数组实现的最大堆
 * @param <E> 泛型
 */
public class MaxHeap<E extends Comparable<E>> {
    private GoodArray<E> data;

    public MaxHeap() {
        this.data = new GoodArray<>();
    }

    //Heapify 方式来进行添加元素
    public MaxHeap(E[] arr){
        this.data = new GoodArray<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    // 返回堆中的数据量
    public int size(){
        return data.getSize();
    }

    // 返回一个布尔值，表示堆中是否为空
    public boolean isEmpty(){
        return data.isEmpty();
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的父节点的索引
    private int parent(int index){
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't exist parent");
        return (index-1)/2;
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的左节点的索引
    private int leftChild(int index){
        return index * 2 + 1;
    }
    //返回完全二叉树的数组表示中，一个索引所表示的元素的右节点的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 向堆中添加元素
     * @param e
     */
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize() -1);

    }

    // 元素上浮操作
    private void siftUp(int k) {

        // 如果父节点值比子节点的小
        while (k> 0 && data.get(parent(k)).compareTo(data.get(k)) < 0){
            // 交换元素
            data.swap(k,parent(k));
            k = parent(k);
        }
    }

    public E findMax(){
        if (data!= null && data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty");
        return data.get(0);
    }

    // 取出堆中的最大值
    public E extractMax(){
        E ret = findMax();

        // 取出最大值后，先将最大值以及数据进行调整，然后移除最后一个值
        data.swap(0,data.getSize() - 1);
        data.removeLast();
        // 下沉操作，维持堆的形态
        siftDown(0);
        return ret;
    }

    // 下沉操作
    private void siftDown(int k) {
        while(leftChild(k) < data.getSize()){

            int j = leftChild(k);
            if (j+1< data.getSize() && data.get(j+1).compareTo(data.get(k)) > 0){
                // 先取rightChild以及leftChild中的最大值，data[j]
                j = rightChild(k);
                if (data.get(k).compareTo(data.get(j)) >= 0)
                    break;
                data.swap(j,k);
                k = j;
            }

        }

    }

    // 替换操作
    public E replace(E e){
        E ret = findMax();
        data.set(0,e);
        siftDown(0);
        return ret;
    }


}
