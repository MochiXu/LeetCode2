package top150;

import java.util.ArrayList;
import java.util.List;

public class permute_46 {
    public List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        bfs(nums,new ArrayList<>());
        return res;
    }
    public void bfs(int[] nums, ArrayList<Integer> steps){
        if (nums.length==steps.size()){
            res.add(new ArrayList<>(steps));
            return;
        }
        for (int i=0; i<nums.length; i++){
            if (!steps.contains(nums[i])){
                steps.add(nums[i]);
                bfs(nums, steps);
                steps.remove(steps.size()-1);
            }
        }
    }

    public static void main(String[] args){
        permute_46 p = new permute_46();
        p.permute(new int[]{1,2,3});
        System.out.println(p.res);
    }
}
