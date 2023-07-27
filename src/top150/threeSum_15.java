package top150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> re = new ArrayList<>();
        for (int i=0; i<nums.length; i++){
            int j=i+1;
            int k= nums.length-1;
            while (j<k){
                int sum = nums[i]+nums[j]+nums[k];
                // 边界判断
                if ((i<nums.length-2&&nums[i]+nums[i+1]+nums[i+2]>0)||nums[nums.length-1]+nums[nums.length-2]+nums[i]<0){
                    break;
                }
                if (sum==0) {
                    List<Integer> inner = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                    if (!re.contains(inner)) {
                        re.add(inner);
                    }
                    k--;
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return re;
    }
}
