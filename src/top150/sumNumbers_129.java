package top150;

import java.util.LinkedList;

public class sumNumbers_129 {
    public int sumNumbers(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        TreeNode cur = root;
        int re=0;
        while (cur!=null||list.size()!=0){
            // 入栈
            while (cur!=null){
                list.addLast(cur);
                cur=cur.left;
            }
            // 出栈
            if (list.size()!=0){
                TreeNode out = list.pollLast();
                cur=out.right;
            }
        }
        return re;
    }

    public int getNumber(LinkedList<TreeNode> list){
        int count=0;
        for (int i=0; i<list.size(); i++){
            count=count+(list.get(i).val * (int) Math.pow(10,(list.size()-i-1)));
        }
        return count;
    }
    public static void main(String[] args){
        sumNumbers_129 s = new sumNumbers_129();
        TreeNode root = new TreeNode(4);
        root.left=new TreeNode(9);
        root.right=new TreeNode(0);
        root.left.left=new TreeNode(5);
        root.left.right=new TreeNode(1);
        System.out.println(s.sumNumbers(root));
    }
}
