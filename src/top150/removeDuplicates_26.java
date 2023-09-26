package top150;

import java.util.HashSet;

public class removeDuplicates_26 {
    public void swap(int[] nums, int left, int right){
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
    }
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int fast=0, slow=0; fast< nums.length; fast++){
            if (!hashSet.contains(nums[fast])){
                hashSet.add(nums[fast]);
                if (slow!=fast){
                    swap(nums, slow+1, fast);
                    slow++;
                }else {
                    slow=fast;
                }
            }else {
                while (fast< nums.length&&hashSet.contains(nums[fast])){
                    fast++;
                }
                if (fast< nums.length) {
                    hashSet.add(nums[fast]);
                    // 遇到重复元素，则交换位置
                    swap(nums, slow + 1, fast);
                    slow++;
                }
            }
        }
        return hashSet.size();
    }

    public static void main(String[] args){
        removeDuplicates_26 r = new removeDuplicates_26();
//        System.out.println(r.removeDuplicates(new int[]{0,2,3,7,2,3,8,0,7,9,4}));
        System.out.println(r.removeDuplicates(new int[]{1,1}));
    }
}
