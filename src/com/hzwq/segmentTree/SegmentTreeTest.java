package com.hzwq.segmentTree;

public class SegmentTreeTest {
    public static void main(String[] args) {
        Integer[] nums = {-2,0,3,-5,2,-1};
        // 匿名函数可以盖层lambda表达式，简化代码
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (a, b) -> {
            //此处如果改成求最大值，以及求最小值的话，那么可以获取到线段树的最大值以及最小值
            return a + b;
        });
//        System.out.println(segmentTree);
        System.out.println(segmentTree.query(0,2));
    }
}
