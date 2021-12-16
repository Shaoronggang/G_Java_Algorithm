package com.hzwq.segmentTree;

public class NumArray_LeetCode303 {

    private SegmentTree<Integer> segmentTree;

    public NumArray_LeetCode303(int[] nums) {
        if (nums.length > 0) {
            Integer[] integers = new Integer[nums.length];
            segmentTree = new SegmentTree<Integer>(integers, ((a, b) -> a + b));
        }

    }

    public int sumRange(int left, int right) {
       return segmentTree.query(left,right);
    }
}
