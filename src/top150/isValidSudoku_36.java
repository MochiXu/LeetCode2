package top150;

import java.util.HashMap;
import java.util.HashSet;

// 有效的数独不一定是可解的
public class isValidSudoku_36 {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Character, Integer> currentRow=new HashMap<>();
        HashMap<Character,Integer> currentCol=new HashMap<>();
        HashMap<Character,Integer> currentBlock = new HashMap<>();
        // 统计所有的列，观察列是否合法
        for (int row=0; row<board.length; row++){
            for (int col=0; col<board[0].length; col++){
                if (currentCol.containsKey(board[row][col])){
                    return false;
                }else if (board[row][col]!='.'){
                    currentCol.put(board[row][col], col);
                }
            }
            currentCol.clear();
        }
        // 统计所有的行，观察行是否合法
        for (int col=0; col<board[0].length; col++){
            for (int row=0; row<board.length; row++){
                if (currentRow.containsKey(board[row][col])){
                    return false;
                }else if (board[row][col]!='.'){
                    currentRow.put(board[row][col], row);
                }
            }
            currentRow.clear();
        }
        // 统计每个小的 block
        // 统计每个小的 block
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                // 检查九宫格
                for (int ii=i; ii<i+3; ii++){
                    for (int jj=j;jj<j+3; jj++){
                        if (currentBlock.containsKey(board[ii][jj])){
                            return false;
                        }else if (board[ii][jj]!='.'){
                            currentBlock.put(board[ii][jj],1);
                        }
                    }
                }
                currentBlock.clear();
            }
        }
        return true;
    }
}
