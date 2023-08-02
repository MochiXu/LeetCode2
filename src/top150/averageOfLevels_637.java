package top150;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class averageOfLevels_637 {
    public List<Double> averageOfLevels(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        ArrayList<Double> re = new ArrayList<>();
        stack.addLast(root);
        while (stack.size()!=0){
            int len = stack.size();
            int sum =0;
            for (int i=0; i<len; i++){
                TreeNode leftOut = stack.pollFirst();
                sum+=leftOut.val;
                if(leftOut.left!=null)stack.addLast(leftOut.left);
                if(leftOut.right!=null)stack.addLast(leftOut.right);
            }
            re.add((double)sum/(double)len);
        }
        return re;
    }
}
