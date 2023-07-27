package top150;

import com.sun.source.tree.Tree;

import java.util.HashMap;

public class lowestCommonAncestor_236 {
    HashMap<TreeNode, Boolean> map = new HashMap<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null){
            return null;
        }
        return minParent(root, p, q);
    }

    public TreeNode minParent(TreeNode node, TreeNode p, TreeNode q){
        if (node==null||node==p||node==q){
            return node;
        }
        TreeNode left = minParent(node.left, p, q);
        TreeNode right = minParent(node.right, p, q);
        if (left==null)return right;
        if (right==null)return left;
        return node;
    }

    public boolean isParent(TreeNode node, TreeNode target){
        if (node==null){
            return false;
        }
        if (node==target){
            return true;
        }
        boolean left = false;
        boolean right = false;
        if(!map.containsKey(node.left)){
            left=isParent(node.left, target);
            map.put(node.left, left);
        }else {
            left=map.get(node.left);
        }
        if (!map.containsKey(node.right)){
            right = isParent(node.right, target);
            map.put(node.right, right);
        }else {
            right=map.get(node.right);
        }
        return left||right;
    }
}
