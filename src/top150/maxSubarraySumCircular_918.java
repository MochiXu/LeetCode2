package top150;

public class maxSubarraySumCircular_918 {
    public int maxSubarraySumCircular(int[] nums) {
        int[] dp = new int[nums.length];
        int re = nums[0];
        int temSum = nums[0];
        dp[0]=nums[0];
        int pre = nums[0];
        for (int i=1; i< nums.length; i++){
            temSum+=nums[i];
            pre = Math.max(nums[i], pre+nums[i]);
            dp[i]=Math.max(dp[i-1], temSum);
            re=Math.max(pre, re);
        }
        int rightSum = 0;
        for (int i= nums.length-1; i>0; i--){
            rightSum += nums[i];
            re = Math.max(rightSum+dp[i-1],re);
        }
        return re;
    }
}
