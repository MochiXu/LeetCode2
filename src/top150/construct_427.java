package top150;

public class construct_427 {
    public class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    };
    public Node construct(int[][] grid) {
        if (grid.length==1){
            return new Node(grid[0][0]==1, true);
        }
        return dfs(grid, grid.length/2, grid.length/2, grid.length/2, 0);
    }

    public Node dfs(int[][] grid, int row, int col, int radius, int direction){
        // 边界判断
        if (row<0||row>=grid.length||col<0||col>=grid.length){
            return null;
        }
        if (radius==0){
            if (direction==0){
                return new Node(grid[row-1][col-1]==1, true);
            } else if (direction == 1) {
                return new Node(grid[row-1][col]==1, true);
            } else if (direction == 2) {
                return new Node(grid[row][col-1]==1, true);
            }else if (direction==3){
                return new Node(grid[row][col]==1, true);
            }
        }
        // 判断是否全为0或者全为1
        int rowStart = row-radius;
        int colStart = col-radius;
        int midVal = grid[rowStart][colStart];
        System.out.println("row"+row+",col"+col+",radius"+radius+",rowStart"+rowStart+",colStart"+colStart+",midVal"+midVal+",iTo"+(rowStart+2*radius)+",jTo"+(colStart+2*radius));
        boolean flag=true;
        for (int i=rowStart; i<rowStart+2*radius; i++){
            for (int j=colStart; j<colStart+2*radius; j++){
                if (midVal!=grid[i][j]){
                    flag=false;
                    break;
                }
            }
        }
        if (flag){
            return new Node(midVal == 1, true);
        }

        // 左上方
        Node topLeft = dfs(grid, row-radius/2, col-radius/2, radius/4, 0);
        // 右上方
        Node topRight = dfs(grid, row-radius/2, col+radius/2, radius/4, 1);
        // 左下方
        Node bottomLeft = dfs(grid, row+radius/2, col-radius/2, radius/4, 2);
        // 右下方
        Node bottomRight = dfs(grid, row+radius/2, col+radius/2, radius/4, 3);

        return new Node(grid[row][col]==1, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}
