package top150;

import java.util.ArrayList;
import java.util.List;

public class combine_77 {
    public List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        dfs(n,1,k,new ArrayList<>());
        return res;
    }

    public void dfs(int n, int cur, int limit, ArrayList<Integer> steps){
        if (limit-steps.size()+cur-1>n){
            return;
        }
        if (steps.size()==limit){
            res.add(new ArrayList<>(steps));
            return;
        }
        for (int i=cur; i<=n; i++){
            // 添加一个元素到 steps
            steps.add(i);
            System.out.println("cur:"+cur+", steps:"+steps);

            dfs(n, i+1, limit, steps);
            // 出栈
            steps.remove(steps.size()-1);
        }
    }
    public static void main(String[] args){
        combine_77 c = new combine_77();
        System.out.println(c.combine(4,2));
    }
}
