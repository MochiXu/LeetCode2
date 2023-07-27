package top150;

import java.util.ArrayList;
import java.util.List;

public class spiralOrder_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] visited = new int[matrix.length][matrix[0].length];
        ArrayList<Integer> re = new ArrayList<>();
        dfs(matrix,visited,0,0,re);
        return re;
    }

    public void dfs(int[][] matrix, int[][] visited, int row, int col, List<Integer> record){
        // 边界判断
        if (row>=matrix.length||col>=matrix[0].length){
            return;
        }
        // 将当前节点标记为已经遍历
        visited[row][col]=1;
        record.add(matrix[row][col]);
        // 左侧已遍历 or 左侧墙壁, 上侧已遍历 or 上侧墙壁, 右侧有未遍历的空间, 向右遍历
        if ( (col-1<0||visited[row][col-1]==1) && (row-1<0||visited[row-1][col]==1) && (col+1<matrix[0].length && visited[row][col+1]==0)){
            dfs(matrix, visited, row, col+1, record);
        }
        // 上侧已遍历 or 上侧墙壁, 右侧已遍历 or 右侧墙壁, 下侧有未遍历的空间, 向下遍历
        if ( (row-1<0||visited[row-1][col]==1) && (col+1>=matrix[0].length||visited[row][col+1]==1) && (row+1<matrix.length && visited[row+1][col]==0)){
            dfs(matrix, visited, row+1, col, record);
        }
        // 下侧已遍历 or 下侧墙壁, 右侧已遍历 or 右侧墙壁, 左侧有未遍历的空间, 向左遍历
        if ( (row+1>=matrix.length || visited[row+1][col]==1) && (col+1>=matrix[0].length || visited[row][col+1]==1) && (col-1>=0 && visited[row][col-1]==0)){
            dfs(matrix, visited, row, col-1, record);
        }
        // 左侧已遍历 or 左侧墙壁, 下侧已遍历 or 下侧墙壁, 上侧有未遍历的空间 向上遍历
        if ( (col-1<0||visited[row][col-1]==1) && (row+1>=matrix.length || visited[row+1][col]==1) && (row-1>=0 && visited[row-1][col]==0)){
            dfs(matrix, visited, row-1, col, record);
        }
    }

    public static void main(String[] args){
        spiralOrder_54 s = new spiralOrder_54();
        System.out.println(s.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }
}
