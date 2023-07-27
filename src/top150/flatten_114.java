package top150;

import java.util.LinkedList;

public class flatten_114 {
    public void flatten(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        LinkedList<TreeNode> listStore = new LinkedList<>();
        TreeNode cur = root;
        while (cur!=null||list.size()!=0){
            while (cur!=null){
                list.addLast(cur);
                listStore.addLast(cur);
                cur=cur.left;
            }
            if (list.size()!=0){
                TreeNode out = list.pollFirst();
                cur=out.right;
            }
        }
        for (int i=0; i<listStore.size()-1; i++){
            listStore.get(i).right=listStore.get(i+1);
        }
    }
}
