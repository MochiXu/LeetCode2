package top150;

public class rotate_48 {
    public void rotate(int[][] matrix) {
        for (int deep=0; deep<matrix.length/2; deep++){
            int[] temp = new int[matrix.length-2*deep];
            int count = (matrix.length-2*deep)%2==0?(matrix.length-2*deep)/2:(matrix.length-2*deep)/2+1;
            System.out.println(count);
            // 暂存上侧行, 使用左侧替换上侧
            for (int col=deep; col<matrix.length-deep-1; col++){
                // 暂存
                temp[col-deep]=matrix[deep][col];
                // 使用左侧替换上侧
                matrix[deep][col]=matrix[matrix.length-col-1][deep];
                // 使用下侧替换左侧
                matrix[matrix.length-col-1][deep]=matrix[matrix.length-deep-1][matrix.length-col-1];
                // 使用右侧替换下侧
                matrix[matrix.length-deep-1][matrix.length-col-1]=matrix[col][matrix.length-deep-1];
                // 使用暂存的值替换右侧
                matrix[col][matrix.length-deep-1] = temp[col-deep];
            }
        }
        System.out.println("");
    }
    public static void main(String[] args){
        rotate_48 r = new rotate_48();
        r.rotate(new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}});

    }
}
