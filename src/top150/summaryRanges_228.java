package top150;

import java.util.ArrayList;
import java.util.List;

public class summaryRanges_228 {
    public List<String> summaryRanges(int[] nums) {
        int left=0;
        ArrayList<String> re = new ArrayList<>();
        for (int i=0; i< nums.length; i++){
            // 边界判断
            if (i== nums.length-1){
                re.add(left!=i ? nums[left]+"->"+nums[i] : String.valueOf(nums[left]));
                break;
            }
            // 下一个数字不能使用区间
            if (nums[i]+1 != nums[i+1]){
                re.add(left!=i ? nums[left]+"->"+nums[i] : String.valueOf(nums[left]));
                // 初始化下一组
                left=i+1;
            }
        }
        return  re;
    }
}
