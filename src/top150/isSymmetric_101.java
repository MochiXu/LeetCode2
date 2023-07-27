package top150;

public class isSymmetric_101 {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricInner(root, root);
    }

    public boolean isSymmetricInner(TreeNode left, TreeNode right){
        if (left==null&&right==null){
            return true;
        }
        if (left==null||right==null){
            return false;
        }
        return isSymmetricInner(left.left, right.right);
    }
}
