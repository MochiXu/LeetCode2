package top150;

import java.util.LinkedList;

public class BSTIterator_173 {
    LinkedList<TreeNode> list = new LinkedList<>();
    int index=0;
    public BSTIterator_173(TreeNode root) {
        inOrder(root);
        index=0;
    }
    public void inOrder(TreeNode root){
        if (root==null){
            return;
        }
        inOrder(root.left);
        list.addLast(root);
        inOrder(root.right);
    }

    public int next() {
        index++;
        return list.get(index+1).val;
    }

    public boolean hasNext() {
        return index+1< list.size();
    }
}
