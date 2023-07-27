package top150;

public class setZeroes_73 {
    public void setZeroes(int[][] matrix) {
        int[][] changed = new int[matrix.length][matrix[0].length];
        for (int row=0; row<matrix.length; row++){
            for (int col=0; col<matrix[0].length; col++){
                if (matrix[row][col]==0&&changed[row][col]==0){
                    // 更改整个行
                    for (int i=0; i<matrix[0].length; i++){
                        changed[row][i]=matrix[row][i]==0&&changed[row][i]==0?0:1;
                        matrix[row][i]=0;
                    }
                    // 更改整个列
                    for (int i=0; i<matrix.length; i++){
                        changed[i][col]=matrix[i][col]==0&&changed[i][col]==0?0:1;
                        matrix[i][col]=0;
                    }
                    changed[row][col]=1;
                    System.out.println("");
                }
            }
        }
        System.out.println("");

    }
    public static void main(String[] args){
        setZeroes_73 s = new setZeroes_73();
        s.setZeroes(new int[][]{{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}});
    }
}
