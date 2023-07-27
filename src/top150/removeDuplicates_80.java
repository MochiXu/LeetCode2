package top150;

import java.util.Arrays;

public class removeDuplicates_80 {

    public void moveForward(int[] nums, int step, int leftIndex, int totalStep){
        for (int i=leftIndex; i<nums.length-totalStep; i++){
            nums[i-step]=nums[i];
        }
    }
    public int removeDuplicates(int[] nums) {
        int pre=nums[0];
        int count=1;
        int totalStep=0;
        for (int i=1; i<nums.length-totalStep; i++){
            // 已经出现了两个重复的数字, 并且又出现了该数字
            if (count==2&&nums[i]==pre){
                // 向右探测，直到找到不同的数字
                int leftIndex=i;
                while (leftIndex<nums.length-totalStep){
                    if (nums[leftIndex]!=nums[i]){
                        break;
                    }
                    leftIndex++;
                }
                // 记录这次实际向左移动的距离
                moveForward(nums, leftIndex-i, leftIndex, totalStep);
                totalStep+=leftIndex-i;
                i--;
                count=1;
            }else if (nums[i]==pre){
                count++;
            }else {
                count=1;
                pre=nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums.length-totalStep;
    }
    public static void main(String[] args){
        removeDuplicates_80 r = new removeDuplicates_80();
        System.out.println(r.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
//        System.out.println(r.removeDuplicates(new int[]{1,1,1}));
    }
}
