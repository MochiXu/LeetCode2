package top150;

import java.util.LinkedList;

public class kthSmallest_230 {
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        int index=0;
        while (stack.size()!=0||cur!=null){
            while (cur!=null){
                stack.addLast(cur);
                cur=cur.left;
            }
            if(stack.size()!=0){
                TreeNode out = stack.pollLast();
                index++;
                if (index==k){
                    return out.val;
                }
                cur=out.right;
            }
        }
        return 0;
    }
}
