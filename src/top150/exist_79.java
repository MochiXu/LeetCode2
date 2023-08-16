package top150;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class exist_79 {
    public boolean exist(char[][] board, String word) {
        char beginWord = word.charAt(0);
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if (board[i][j]==beginWord){
                    arrayList.add(new ArrayList<>(Arrays.asList(i,j)));
                }
            }
        }
        boolean exists=false;
        for (int i=0; i<arrayList.size(); i++){
            exists|=dfs(board, new boolean[board.length][board[0].length], word, 0, arrayList.get(i).get(0),arrayList.get(i).get(1));
            if (exists){
                return true;
            }
        }
        return false;

    }

    public boolean dfs(char[][] board, boolean[][] visited, String word, int index, int row, int col){
        visited[row][col]=true;
        if (board[row][col]!=word.charAt(index)){
            return false;
        }
        if (index>=(word.length()-1)){
            return true;
        }
        boolean top=false;
        if (row-1>=0 && !visited[row-1][col]){
            top = dfs(board, visited, word, index+1, row-1, col);
            visited[row-1][col]=false;
        }
        boolean left=false;
        if (col-1>=0 && !visited[row][col-1]){
            left = dfs(board, visited, word, index+1, row, col-1);
            visited[row][col-1]=false;
        }
        boolean right=false;
        if (col+1<board[0].length && !visited[row][col+1]){
            right = dfs(board, visited, word, index+1, row, col+1);
            visited[row][col+1]=false;
        }
        boolean down=false;
        if (row+1<board.length && !visited[row+1][col]){
            down = dfs(board, visited, word, index+1, row+1, col);
            visited[row+1][col]=false;
        }
        return top||left||right||down;
    }

    public static void main(String[] args){
        exist_79 e = new exist_79();
        System.out.println(e.exist(new char[][]{{'a','b'},{'c','d'}}, "acdb"));
    }
}
