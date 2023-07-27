package top150;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class buildTree_105 {
    public TreeNode buildTree(int[] preorder,int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft==preRight && inLeft==inRight && preorder[preLeft]==inorder[inLeft]){
            return new TreeNode(preorder[preLeft]);
        }
        if (preLeft>preRight || inLeft>inRight){
            return null;
        }
        int root = preorder[preLeft];
        int rootIndex = inLeft;
        while (rootIndex <= inRight){
            if (inorder[rootIndex]==root){
                break;
            }
            rootIndex++;
        }
        // 计算左侧长度
        int leftSpace = rootIndex-inLeft;
        // 计算右侧长度
        TreeNode left = buildTree(preorder, preLeft+1, preLeft+leftSpace, inorder, inLeft, rootIndex-1);
        TreeNode right = buildTree(preorder, preLeft+leftSpace+1, preRight, inorder, rootIndex+1, inRight);
        TreeNode rootT = new TreeNode(root);
        rootT.left=left;
        rootT.right=right;
        return rootT;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,0, preorder.length -1, inorder, 0 , inorder.length-1);
    }
}
