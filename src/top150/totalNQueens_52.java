package top150;

public class totalNQueens_52 {
    public int re=0;
    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        dfs(board,0);
        return re;
    }
    public boolean dfs(boolean[][] board, int row){
        if (row>=board.length){
            return true;
        }
        boolean atLeastOneValid=false;
        for (int col=0; col<board.length; col++){
            if(isValid(board, row, col)){
                board[row][col]=true;
                boolean next = dfs(board, row+1);
                board[row][col]=false;
                atLeastOneValid=true;
            }
        }
        if (row==board.length-1&&atLeastOneValid){
            re+=1;
        }
        return atLeastOneValid;
    }

    public boolean isValid(boolean[][] board, int row, int col){
        // 判断当前列是否存在皇后
        for (int r=0; r<row; r++){
            if (board[r][col]){
                return false;
            }
        }
        int m=Math.max(row,col);
        // 判断左右对角线是否存在皇后
        for (int i=1; i<=m; i++){
            if (row-i>=0&&col-i>=0&&board[row-i][col-i]){
                return false;
            }
            if (row-i>=0&&col+i<board.length && board[row-i][col+i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        totalNQueens_52 t = new totalNQueens_52();
        System.out.println(t.totalNQueens(4));
    }
}
