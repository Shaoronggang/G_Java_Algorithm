package com.hzwq.tree.banirySTree;

public class TreeTest {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 4, 6, 8, 2};
        for (int i = 0; i < nums.length; i++) {
            bst.add(nums[i]);
        }

//        bst.preOrder();
//
//        System.out.println();
//        bst.preOrderNR();
//        System.out.println();
//        bst.levelOrder();
//        System.out.println();
//        bst.inOrder();
//        System.out.println();
//        bst.postOrder();
//        System.out.println();
////        System.out.println(bst);
//        System.out.println(bst.minimum());
//        System.out.println(bst.maximum());
        System.out.println();
        bst.removeMax();
        bst.inOrder();
        System.out.println();
        bst.removeMin();
        System.out.println();
        bst.inOrder();


    }
}
