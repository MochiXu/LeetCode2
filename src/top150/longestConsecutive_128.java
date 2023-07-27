package top150;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class longestConsecutive_128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i=0; i<nums.length; i++){
            hashSet.add(nums[i]);
        }
        int re =0;
        for (int num: hashSet){
            if (!hashSet.contains(num-1)){
                int count=0;
                int curNum = num;
                while (hashSet.contains(curNum)){
                    count++;
                    curNum++;
                }
                re= Math.max(re, count);
            }
        }
        return re;
    }
}
