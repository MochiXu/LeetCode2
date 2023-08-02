package top150;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class rightSideView_199 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root==null)return null;
        ArrayList<Integer> re = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (queue.size()!=0){
            re.add(queue.getLast().val);
            int len=queue.size();
            for (int i=0; i<len; i++){
                TreeNode out = queue.pollFirst();
                if (out.left!=null) queue.addLast(out.left);
                if (out.right!=null) queue.addLast(out.right);
            }
        }
        return re;
    }
}
