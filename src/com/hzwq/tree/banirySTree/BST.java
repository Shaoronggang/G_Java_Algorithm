package com.hzwq.tree.banirySTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二分搜索树，存储的元素需要继承自比较接口，具有可比性
 *
 * @param <E>
 */
public class BST<E extends Comparable<E>> {

    private class Node {
        E e;
        Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    // 存储数据量
    private int size;
    //根节点
    private Node root;

    public BST() {
        this.size = 0;
        root = null;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public void add(E e) {
        /*--------------------递归终止条件改进前代码------------*/
//        if (root == null){
//            root = new Node(e);
//            size++;
//        }
//        else {
//            add(root,e);
//        }
        /*--------------------改进前代码------------*/

        /*--------------------递归终止条件改进后代码------------*/
        root = add(root, e);
        /*--------------------递归终止条件改进后代码------------*/
    }

    /*--------------------改进前代码------------*/
    // 向以的node为根的二分搜索树中插入元素E，递归算法
//    private void add(Node node, E e) {
//        // 基本问题，结束情况
//        if (e.compareTo(node.e) == 0) {
//            return;
//        } else if (e.compareTo(node.e) < 0 && node.left == null) {
//            node.left = new Node(e);
//            size++;
//            return;
//        } else if (e.compareTo(node.e) > 0 && node.right == null) {
//            node.right = new Node(e);
//            size++;
//            return;
//        }
//
//        // 递归操作
//        if (e.compareTo(node.e) < 0)
//            add(node.left, e);
//        else
//            add(node.right, e);
//
//    }

    /*--------------------改进前代码------------*/

    /*--------------------改进后代码------------*/
    // 向以的node为根的二分搜索树中插入元素E，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, E e) {
        // 递归终止条件
//        if (e.compareTo(node.e) == 0) {
//            return;
//        } else if (e.compareTo(node.e) < 0 && node.left == null) {
//            node.left = new Node(e);
//            size++;
//            return;
//        } else if (e.compareTo(node.e) > 0 && node.right == null) {
//            node.right = new Node(e);
//            size++;
//            return;
//        }

        if (node == null) {
            size++;
            node = new Node(e);
            return node;
        }

        // 递归操作
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;

    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    // node为根的二分搜索树是否包含e,递归算法
    private boolean contains(Node node, E e) {
        if (node == null)
            return false;
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else
            return contains(node.right, e);
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 前序遍历的非递归实现，使用了栈来进行存储
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }

    public void levelOrder(){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node cur = q.remove();
            System.out.println(cur.e);

            if (cur.left != null)
                q.add(cur.left);
            if (cur.right != null)
                q.add(cur.right);
        }

    }

    public E minimum(){
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");
        return minimum(root).e;
    }

    // 返回node为根节点的节点下最小值节点
    private Node minimum(Node node){
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    // 删除二叉树中的最小值
    private Node removeMin(Node node){
        if (node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    public E maximum(){
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");
        return maximum(root).e;
    }

    // 返回node节点下面的最大值节点
    private Node maximum(Node node){
        if (node.right == null)
            return node;
        return maximum(node.right);
    }

    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    // 删除二叉树中的最大值
    private Node removeMax(Node node){
        if (node.right == null){
            Node rightNode = node.left;
            node.left = null;
            size--;
            return rightNode;
        }

        node.right = removeMax(node.right);
        return node;
    }


    public void remove(E e){
        root = remove(root,e);
    }

    //  删除node为根节点的下面值为e的节点
    private Node remove(Node node, E e) {
        if (node == null)
            return null;
        if (e.compareTo(node.e) < 0){
            node.left = remove(node.left,e);
            return node;
        }else if (e.compareTo(node.e) > 0){
            node.right = remove(node.right,e);
            return node;
        }else { // e == node.e
            // 待删除节点左子树为空的情况
            if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            // 待删除节点的右子树为空的情况
            if (node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            /* 1.待删除节点左右均不为空
            * 找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            *用这个节点顶替删除节点的位置
            * */
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            return successor;
        }

    }


    // 二叉树的中序遍历
    public void inOrder() {
        inOrder(root);
    }

    // 中序遍历以node为根的的二叉搜索树，递归算法
    private void inOrder(Node node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    // 二叉树的后序遍历
    public void postOrder() {
        postOrder(root);
    }

    // 后序遍历以node为根的的二叉搜索树，递归算法
    private void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }

    /**
     * 生成以node为根节点，深度为depth的描述二叉树的字符串,递归调试的一个概念——深度
     * @param node
     * @param depth 深度
     * @param res
     */
    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left,depth + 1,res);
        generateBSTString(node.right,depth + 1,res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++)
            res.append("--");
        return res.toString();
    }
}
