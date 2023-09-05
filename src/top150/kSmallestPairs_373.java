package top150;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
/**
 * 关于如何去重可以参考
 * https://leetcode.cn/problems/find-k-pairs-with-smallest-sums/solutions/1210221/bu-chong-guan-fang-ti-jie-you-xian-dui-l-htf8/
 * 建议仔细观察 O(n^2) 是如何出现重复的
 * */
public class kSmallestPairs_373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<>((a,b)->nums1[a.get(0)]+nums2[a.get(1)]-nums1[b.get(0)]-nums2[b.get(1)]);
        List<List<Integer>> res = new ArrayList<>();
        for (int i=0; i<Math.min(k, nums1.length); i++){
            priorityQueue.add(new ArrayList<>(List.of(i, 0)));
        }
        while (k>0&&priorityQueue.size()!=0){
            List<Integer> minor = priorityQueue.poll();
            res.add(new ArrayList<>(List.of(nums1[minor.get(0)], nums2[minor.get(1)])));
            if (minor.get(1)+1<nums2.length){
                priorityQueue.add(new ArrayList<>(List.of(minor.get(0), minor.get(1)+1)));
            }
            k--;
        }
        return res;
    }
}
