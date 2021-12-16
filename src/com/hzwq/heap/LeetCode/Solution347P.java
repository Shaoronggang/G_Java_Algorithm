package com.hzwq.heap.LeetCode;

//import com.hzwq.queue.PriorityQueue;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * LeetCode上第347问题
 * java中是最小堆，我们自己实现的堆是最大堆
 */
public class Solution347P {

    public static void main(String[] args) {
        Solution347P solution347P = new Solution347P();
        int[] nums = new int[]{1,1,1,2,2,3};
        solution347P.topKFrequent(nums,2);
    }

    private class Freq implements Comparable<Freq> {
        int e, freq;

        public Freq(int key, Integer freq) {
            this.e = key;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            // 频次越高，优先级越低
            if (this.freq < another.freq)
                return -1;
            else if (this.freq > another.freq)
                return 1;
            else
                return 0;
        }
    }

    /**
     * 前K个高频元素
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num :
                nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }


//        PriorityQueue<Freq> pq = new PriorityQueue(new Comparator<Freq>() {
//            @Override
//            public int compare(Freq a, Freq b) {
//                return a.freq - b.freq;
//            }
//        });
//        for (int key:
//             map.keySet()) {
//            if (pq.size() < k){
//                pq.add(new Freq(key,map.get(key)));
//            }else if(map.get(key) > pq.peek().freq) {
//                pq.remove();
//                pq.add(new Freq(key,map.get(key)));
//            }
//        }
//
//        LinkedList<Integer> list = new LinkedList<>();
//        while(!pq.isEmpty()){
//            list.add(pq.remove().e);
//        }
//
//        int[] res = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            res[i] = list.get(i);
//        }
//        return res;


        /*------------------------方案二：----------------------*/

        PriorityQueue<Integer> pq = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        for (int key:
                map.keySet()) {
            if (pq.size() < k){
                pq.add(key);
            }else if(map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }

        LinkedList<Integer> list = new LinkedList<>();
        while(!pq.isEmpty()){
            list.add(pq.remove());
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;


    }
}
