package com.hzwq.linkList;


/**
 * 数组求和，递归的最简化的学习
 */
public class Sum {
    public static int sum(int[] arr){
        return sum(arr,0);
    }

    // 计算arr[l...n]这个区间内所有数字的和

    /**
     *
     * sum(arr[0...n-1]) = arr[0] + sum(arr[1...n-1])  更小的同一问题
     * sum(arr[1...n-1]) = arr[1] + sum(arr[2...n-1])  更小的同一问题
     *  。。。。。。
     * sum(arr[n-1...n-1]) = arr[n-1] + sum([]) 最基本的问题
     * @param arr
     * @param l
     * @return
     */
    private static int sum(int[] arr,int l){
        // 则意味着一个元素都没有添加
        if (arr.length == l)
            return 0;
        return arr[l] + sum(arr,l+1);
    }

    public static void main(String[] args) {
        int[] nums  = {1,2,3,4,5,6};
        System.out.println(sum(nums));
    }
}
