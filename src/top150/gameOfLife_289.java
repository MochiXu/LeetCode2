package top150;

public class gameOfLife_289 {
    public int getLife(int[][] board, int row, int col){
        int leftTop = row-1>=0&&col-1>=0?board[row-1][col-1]:0;
        int top = row-1>=0?board[row-1][col]:0;
        int rightTop = row-1>=0&&col+1<board[0].length?board[row-1][col+1]:0;
        int left = col-1>=0?board[row][col-1]:0;
        int right = col+1<board[0].length?board[row][col+1]:0;
        int leftBottom = row+1<board.length&&col-1>=0?board[row+1][col-1]:0;
        int bottom = row+1<board.length?board[row+1][col]:0;
        int rightBottom = col+1<board[0].length&&row+1<board.length?board[row+1][col+1]:0;
        int sum = leftTop+top+rightTop+left+right+leftBottom+bottom+rightBottom;
        if (sum==3){
            return 1;
        }
        if (sum<2){
            return 0;
        }
        if (sum>3){
            return 0;
        }
        return board[row][col];
    }
    public void gameOfLife(int[][] board) {
        int[][] re = new int[board.length][board[0].length];
        for (int row=0; row<board.length; row++){
            for (int col=0; col<board[0].length; col++){
                re[row][col] = getLife(board, row, col);
            }
        }
        for (int row=0; row<board.length; row++){
            for (int col=0; col<board[0].length; col++){
                board[row][col] = re[row][col];
            }
        }
    }
    public static void main(String[] args){
        int[] arr = new int[]{1,2,3};
        int[] bg = arr;
        bg[0]=3;
        System.out.println(arr);
        System.out.println(bg);
    }
}
