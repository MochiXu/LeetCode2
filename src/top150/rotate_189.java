package top150;

import java.util.Arrays;

public class rotate_189 {
    public void rotate(int[] nums, int k) {
        for (int i=0; i<k; i++){
            // 向右移动一次
            int last = nums[nums.length-1];
            for (int j=nums.length-2; j>=0; j--){
                nums[j+1]=nums[j];
            }
            nums[0]=last;
        }
    }

    public void revert(int[] nums, int left, int right){
        while (left<right){
            int p = nums[left];
            nums[left]=nums[right];
            nums[right]=p;
            left++;
            right--;
        }
    }
    public void rotate1(int[] nums, int k) {
        revert(nums,0, nums.length-1);
        revert(nums,0,k-1);
        revert(nums, k,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
    public static void main(String[] args){
        rotate_189 r = new rotate_189();
        r.rotate1(new int[]{1,2,3,4,5,6,7},3);
    }
}
