package top150;

import java.util.LinkedList;

public class countNodes_222 {
    LinkedList<TreeNode> list = new LinkedList<>();
    public int countNodes(TreeNode root) {
        TreeNode cur = root;
        int count=0;
        while (cur!=null||list.size()!=0){
            while (cur!=null){
                list.addLast(cur);
                cur=cur.left;
            }
            if (list.size()!=0){
                count++;
                System.out.println(list.getLast().val);
                cur=list.pollLast();
                cur=cur.right;
            }
        }
        return count;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        countNodes_222 c = new countNodes_222();
        c.countNodes(root);
    }
}
