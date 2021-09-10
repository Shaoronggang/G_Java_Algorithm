package com.hzwq.aggregate.LeetCode;

import com.hzwq.aggregate.Map;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Problem349 {
    public static void main(String[] args) {

    }

    public int[] intersection(int[] nums1, int[] nums2) {

        /*----------------我的算法-------------*/
        TreeSet<Integer> set = new TreeSet<>();
        TreeSet<Integer> set1 = new TreeSet<>();
        List<Integer> list = new ArrayList<>();
        for (Integer num : nums1
        ) {
            set.add(num);
        }

        for (Integer num : nums2
        ) {
            if (set.contains(num) ) {
                list.add(num);
                set.remove(num);
            }
        }

        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }

        return ret;
        /*----------------我的算法-------------*/


    }

}
