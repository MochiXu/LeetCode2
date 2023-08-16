package top150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class findWords_212 {
    public List<String> findWords(char[][] board, String[] words) {
        HashMap<Character,List<Integer>> hashMap = new HashMap<>();
        // 遍历 board 记录下每个字母的索引
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if (hashMap.containsKey(board[i][j])){
                    hashMap.get(board[i][j]).add(i*board[0].length+j);
                }else {
                    hashMap.put(board[i][j], new ArrayList<>(List.of(i * board[0].length + j)));
                }
            }
        }
        ArrayList<String> res = new ArrayList<>();
        for (String word: words){
            if (hashMap.containsKey(word.charAt(0))){
                List<Integer> indexList = hashMap.get(word.charAt(0));
                for (int i=0; i<indexList.size(); i++){
                    int row = indexList.get(i) / board[0].length;
                    int col = indexList.get(i) % board[0].length;
                    boolean exist = dfs(board, new boolean[board.length][board[0].length], row, col, 0, word);
                    if (exist){
                        res.add(word);
                        break;
                    }
                }
            }
        }
        return res;
    }

    public boolean dfs(char[][] board, boolean[][] visited, int row, int col, int curIndex, String word){
        if (curIndex==word.length()-1){
            return true;
        }
        if ( word.charAt(curIndex)!=board[row][col]){
            return false;
        }
        visited[row][col]=true;
        // 向右
        boolean right=false;
        if (col+1<board[0].length && !visited[row][col+1] && word.charAt(curIndex)==board[row][col] && word.charAt(curIndex+1)==board[row][col+1]){
            right=dfs(board, visited, row, col+1, curIndex+1, word);
        }
        // 向下
        boolean down=false;
        if (row+1<board.length && !visited[row+1][col] && word.charAt(curIndex)==board[row][col] && word.charAt(curIndex+1)==board[row+1][col]){
            down=dfs(board, visited, row+1, col, curIndex+1, word);
        }
        // 向左
        boolean left = false;
        if (col-1>=0 && !visited[row][col-1] && word.charAt(curIndex)==board[row][col] && word.charAt(curIndex+1)==board[row][col-1]){
            left=dfs(board, visited, row, col-1, curIndex+1, word);
        }
        // 向上
        boolean up=false;
        if (row-1>=0 && !visited[row-1][col] && word.charAt(curIndex)==board[row][col] && word.charAt(curIndex+1)==board[row-1][col]){
            up=dfs(board, visited, row-1, col, curIndex+1, word);
        }
        visited[row][col]=false;
        return right||down||left||up;
    }

    public static void main(String[] args){
        findWords_212 f = new findWords_212();
//        System.out.println(f.findWords(new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}}, new String[]{"oath","pea","eat","rain"}));
//        System.out.println(f.findWords(new char[][]{{'o','a','b','n'},{'o','t','a','e'},{'a','h','k','r'},{'a','f','l','v'}}, new String[]{"oa","oaa"}));
//        System.out.println(f.findWords(new char[][]{{'a','b','c'},{'a','e','d'},{'a','f','g'}}, new String[]{"abcdefg","gfedcbaaa","eaabcdgfa","befa","dgc","ade"}));
        System.out.println(f.findWords(new char[][]{{'a','b','c', 'e'},{'x','x','c','d'},{'x','x','b','a'}}, new String[]{"abcd"}));
//        System.out.println(f.findWords(new char[][]{{'a','b','c'},{'a','e','d'},{'a','f','g'}}, new String[]{"eaabcdgfa"}));
//        System.out.println(f.findWords(new char[][]{{'a','a'}}, new String[]{"aa"}));
    }
}
