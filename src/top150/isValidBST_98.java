package top150;

public class isValidBST_98 {
    public  boolean valid=true;
    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return valid;
    }

    // 返回值表示 min/max
    public int[] dfs(TreeNode node){
        if (node.left==null&&node.right==null){
            return new int[]{node.val,node.val};
        }
        int[] left  = new int[]{node.val,node.val};
        int[] right  = new int[]{node.val,node.val};
        if (node.left!=null){
            left=dfs(node.left);
        }
        if(node.right!=null){
            right = dfs(node.right);
        }
        if ((node.left!=null&&node.val<=left[1])||(node.right!=null&&node.val>=right[0])){
            valid=false;
        }
        System.out.println("left:["+left[0]+","+left[1]+"], right:["+right[0]+","+right[1]+"]; node.val:"+node.val);
        int[] re = new int[2];
        if (node.left!=null&&node.right!=null){
            re=new int[]{Math.min(Math.min(left[0],right[0]),node.val),Math.max(Math.max(left[1],right[1]),node.val)};
        }else if(node.left!=null){
            re=new int[]{Math.min(left[0],node.val),Math.max(left[1],node.val)};
        }else if(node.right!=null){
            re=new int[]{Math.min(right[0],node.val),Math.max(right[1],node.val)};
        }
        return re;
    }
}
