package top150;

import com.sun.source.tree.Tree;

import java.util.LinkedList;

public class maxDepth_104 {
    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode node, int deep){
        if (node==null){
            return 0;
        }
        return Math.max(dfs(node.left, deep), dfs(node.right, deep))+1;
    }
}
