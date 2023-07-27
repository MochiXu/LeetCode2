package top150;

import java.util.LinkedList;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
public class connect_117 {
    public Node connect(Node root) {
        if (root==null){
            return null;
        }
        LinkedList<Node> list = new LinkedList<>();
        list.addLast(root);
        // 增加一个分界线
        list.addLast(new Node(Integer.MIN_VALUE));
        while (list.size()!=0){
            Node out = list.pollFirst();
            if (out.val==Integer.MIN_VALUE){
                if (list.size()!=0){
                    list.addLast(new Node(Integer.MIN_VALUE));
                }
                continue;
            }
            // 新增节点间指向
            if (list.getFirst()!=null && list.getFirst().val!=Integer.MIN_VALUE){
                out.next=list.getFirst();
            }
            if (out.left!=null){
                list.addLast(out.left);
            }
            if(out.right!=null){
                list.addLast(out.right);
            }
        }
        return root;
    }
    public static void main(String[] args){
//        [1,2,3,4,5,null,7]
        connect_117 c = new connect_117();
        Node root = new Node(1);
        root.left=new Node(2);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right=new Node(3);
        root.right.right=new Node(7);
        System.out.println(c.connect(root));
    }
}
