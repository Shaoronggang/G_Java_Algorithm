package com.hzwq.segmentTree;


/**
 * 线段树,非完全二叉树，但是平衡二叉树
 */
public class SegmentTree<E> {
    // 用来存储成树结构
    private E[] tree;
    // 添加数据
    private E[] data;

    private Merger<E> merger;

    /**
     * @param arr
     * @param merger
     */
    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;
        // 此处注意引入的相应的Object包文件不要出错。
        data = (E[])new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }

        tree = (E[]) new Object[4 * arr.length];

        buildSegmentTree(0, 0, data.length - 1);
    }

    /**
     * 在treeIndex的位置创建表示区间[l...r]的线段树
     *
     * @param treeIndex 当前值下标
     * @param r         当前线段树右侧下标
     * @param l         当前线段树左侧下标
     */
    private void buildSegmentTree(int treeIndex, int l, int r) {
        // 先完成递归完成的条件
        if (r == l) {
            tree[treeIndex] = data[l];
            return;
        }

        // 然后，添加相应的逻辑：r~mid,以及mid~l
        int leftTreeIndex = leftChild(treeIndex); // 获取线段树左边的下标
        int rightTreeIndex = rightChild(treeIndex);// 获取线段树右边的下标

//        int mid = (l + r)/2;// 可能存在溢出问题
        int mid = l + (r - l) / 2;
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);

        // 对结果进行融合
        tree[treeIndex] = merger.merger(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public int getSize() {
        return data.length;
    }

    /**
     * 返回区间[queryL,queryR]的值,线段树结果需要根据业务逻辑来处理相应的数据
     * @param queryL 搜索范围左边下标
     * @param queryR  搜搜范围的右边的下标
     * @return
     */
    public  E query(int queryL,int queryR){
        if (queryL < 0 || queryR < 0 || queryL > queryR || queryL >= data.length || queryR > data.length) {
            throw new IllegalArgumentException("index is illegal");
        }

        return query(0,0,data.length-1,queryL,queryR);
    }

    /**
     * 在以treeID为根的线段树中[l...r]的范围里，搜索区间[queryL...queryR]的值
     * @param treeIndex 跟节点的下标
     * @param l 线段树起始下标
     * @param r 线段树结束下标
     * @param queryL 查询部分起始下标
     * @param queryR 查询部分结束下标
     * @return
     */
    private E query(int treeIndex,int l,int r,int queryL,int queryR){
            if (l == queryL && r == queryR){
                return tree[treeIndex];
            }

            int mid = l + (r - l)/2;
            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);

            if (queryL >= mid + 1){
               return query(rightTreeIndex,mid,r,queryL,queryR);
            }else if (queryR <= mid){
               return query(leftTreeIndex,l,mid,queryL,queryR);
            }

            E leftResult = query(leftTreeIndex,l,mid,queryL,mid);
            E rightResult = query(rightTreeIndex,mid + 1,r,mid + 1,queryR);
            return merger.merger(leftResult,rightResult);
    }

    public E get(int index) {
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is Illegal");
        return data[index];
    }

    // 返回完全二叉树中，一个索引所表示的元素的左孩子的节点的索引
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    // 返回完全二叉树中，一个索引所表示的元素的右孩子的节点的索引
    private int rightChild(int index) {
        return 2 * index + 2;
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                res.append(tree[i]);
            } else {
                res.append("null");
            }

            if (i != tree.length - 1)
                res.append(",");
        }
        res.append("]");

        return res.toString();
    }
}
