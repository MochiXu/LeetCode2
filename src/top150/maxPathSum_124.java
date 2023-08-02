package top150;

public class maxPathSum_124 {
    public int maxSumBoth = Integer.MIN_VALUE;
    public int maxSumSingle = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return Math.max(maxSumBoth, maxSumSingle);
    }

    public int dfs(TreeNode node){
        if (node==null){
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
//        System.out.println("left:"+left+", right:"+right+", cur:"+node.val);
        maxSumBoth=Math.max(left+right+node.val, maxSumBoth);
//        System.out.println(Math.max(left, right) + node.val);
        int single=Math.max(left, right) + node.val;
        maxSumSingle=Math.max(single, maxSumSingle);
        return Math.max(0, single);
    }
}
