package top150;

import java.util.LinkedList;

public class sumNumbers_129_2 {
    public LinkedList<TreeNode> list = new LinkedList<>();
    public int re=0;
    public int sumNumbers(TreeNode root) {
        dfs(root, list);
        return re;
    }
    public void dfs(TreeNode node, LinkedList<TreeNode> list){
        if (node==null){
            return;
        }
        list.addLast(node);
        if (node.left==null&&node.right==null){
            re+=getNumber(list);
        }

        dfs(node.left, list);
        dfs(node.right, list);
        list.pollLast();
    }
    public int getNumber(LinkedList<TreeNode> list){
        int count=0;
        for (int i=0; i<list.size(); i++){
            System.out.print(list.get(i)+" ");
            count=count+(list.get(i).val * (int) Math.pow(10,(list.size()-i-1)));
        }
        System.out.println("");
        return count;
    }
}
