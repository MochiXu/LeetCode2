package top150;

public class buildTree_106 {
    public TreeNode buildTreeInner(int[] inorder, int inLeft, int inRight, int[] postorder, int poLeft, int poRight){
        if (inLeft==inRight && poLeft==poRight && inorder[inLeft]==postorder[poLeft]){
            return new TreeNode(inorder[inLeft]);
        }
        if(inLeft<0||inLeft>=inorder.length||inRight>=inorder.length||inRight<0||inLeft>inRight){
            return null;
        }
        if(poLeft<0||poLeft>=postorder.length||poRight>=postorder.length||poRight<0||poLeft>poRight){
            return null;
        }
        int rootIndex = poRight;
        int min = inLeft;
        while (inorder[min]!=postorder[rootIndex]){
            min++;
        }
        // 统计 left 长度
        int leftLength = min-inLeft;
        TreeNode leftTreeNode = buildTreeInner(inorder, inLeft, min-1, postorder, poLeft, poLeft+leftLength-1);
        TreeNode rightTreeNode = buildTreeInner(inorder, min+1, inRight, postorder, poLeft+leftLength, poRight-1);
        TreeNode root = new TreeNode(postorder[rootIndex]);
        root.left=leftTreeNode;
        root.right=rightTreeNode;
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeInner(inorder, 0, inorder.length-1, postorder, 0, inorder.length-1);
    }
}
