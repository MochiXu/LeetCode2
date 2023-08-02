package top150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class calcEquation_399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        ArrayList<String> vars = new ArrayList<>();
        for (List<String> list : equations){
            // 将所有的字符存储在 vars
            if (!vars.contains(list.get(0))){
                vars.add(list.get(0));
            }
            if (!vars.contains(list.get(1))){
                vars.add(list.get(1));
            }
        }
        double[][] grid=new double[vars.size()][vars.size()];
        // 初始化对角线
        for (int i=0; i<vars.size(); i++){
            grid[i][i]=1;
        }
        // 初始化 grid
        for (int i=0; i< values.length; i++){
            int row = vars.indexOf(equations.get(i).get(0));
            int col = vars.indexOf(equations.get(i).get(1));
            grid[row][col] = values[i];
            grid[col][row] = 1.0/values[i];
        }
        // 推导 grid
        double[] re = new double[queries.size()];
        for (int i=0; i<queries.size(); i++){
            if (!vars.contains(queries.get(i).get(0))||!vars.contains(queries.get(i).get(1))){
                re[i]=-1.0;
                continue;
            }
            double res=dfs(grid, vars, new ArrayList<>(), queries.get(i).get(0), queries.get(i).get(1));
            re[i]=res==0?-1.0:res;
        }
        return re;

    }
    public double dfs(double[][] grid, ArrayList<String> vars, ArrayList<String> pres, String cur, String target){
        int cur_index = vars.indexOf(cur);
        int target_index = vars.indexOf(target);
        // 找到目标值, 则返回结果
        if (grid[cur_index][target_index]!=0){
            return grid[cur_index][target_index];
        }

        // 获得所有下一次的 cur_index
        double ans = 0.0;
        for (int i=0; i<grid.length; i++){
            if (i==cur_index) continue;
            if (pres.contains(vars.get(i))) continue;

            // 可能的路径
            if (grid[cur_index][i]!=0){
                System.out.println("next-"+vars.get(i));
                pres.add(vars.get(i));
                ans = dfs(grid, vars, pres, vars.get(i), target) * grid[cur_index][i];
            }
            if (ans!=0){
                return ans;
            }
        }
        return ans;
    }
}
