package top150;

public class getMinimumDifference_530 {
    public int minSub = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if (root!=null&&root.left!=null){
            //需要找到左侧最大的数字
            TreeNode cur = root.left;
            int leftMax = cur.val;
            while (cur!=null){
                leftMax=cur.val;
                cur=cur.right;
            }
            minSub=Math.min(root.val-leftMax, minSub);
        }
        if(root!=null&&root.right!=null){
            //需要找到右侧最小的数字
            TreeNode cur = root.right;
            int rightMin = cur.val;
            while (cur!=null){
                rightMin=cur.val;
                cur=cur.left;
            }
            minSub=Math.min(rightMin-root.val, minSub);
        }
        if (root==null){
            return 0;
        }
        if(root.left!=null){
            getMinimumDifference(root.left);
        }
        if (root.right!=null){
            getMinimumDifference(root.right);
        }
        return minSub;

    }
}
