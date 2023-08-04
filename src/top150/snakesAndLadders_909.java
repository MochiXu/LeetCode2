package top150;

import java.util.ArrayList;
import java.util.LinkedList;

public class snakesAndLadders_909 {
    public int snakesAndLadders(int[][] board) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean right=true;
        for (int i=board.length-1; i>=0; i--){
            if (right){
                for (int j=0; j<board[0].length; j++){
                    list.add(board[i][j]);
                }
                right=false;
            }else {
                for (int j=board[0].length-1; j>=0; j--){
                    list.add(board[i][j]);
                }
                right=true;
            }
        }
        return bfs(list, 0);
    }

    public int bfs(ArrayList<Integer>list,  int curIndex){
        boolean[] vis = new boolean[list.size()];
        LinkedList<int[]> stack = new LinkedList<>();
        stack.addLast(new int[]{curIndex, 0});
        while (stack.size()!=0){
            int[] top = stack.pollFirst();
            System.out.println("pop ["+top[0]+","+top[1]+"]");
            for (int i=1; i<=6; i++){
                int nextIndex = top[0]+i;
                if (nextIndex>=list.size()){
                    // TODO 此处的 break 结合画图分析下
                    break;
                }
                if (list.get(nextIndex)!=-1){
                    // 存在蛇梯
                    nextIndex=list.get(nextIndex)-1;
                }
                if (nextIndex==list.size()-1){
                    // 到达终点
                    return top[1]+1;
                }
                if (!vis[nextIndex]){
                    // 防止无限循环
                    vis[nextIndex]=true;
                    System.out.println("add ["+nextIndex+","+(top[1]+1)+"]");
                    stack.addLast(new int[]{nextIndex, top[1]+1});
                }
            }
        }
        return -1;
    }


    public static void main(String[] args){
        snakesAndLadders_909 s = new snakesAndLadders_909();
        System.out.println(s.snakesAndLadders(new int[][]{{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}}));
//        System.out.println(s.snakesAndLadders(new int[][]{{-1,-1},{-1,3}}));
    }
}
