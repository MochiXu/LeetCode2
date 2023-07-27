package top150;

import java.util.HashMap;

public class copyRandomList_138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        // oldToNew 记录 old -> new copy 的关系
        HashMap<Node, Node> oldToNew = new HashMap<>();
        // newToOld 记录 new copy -> old 的关系
        HashMap<Node, Node> newToOld = new HashMap<>();
        Node fakeHead = new Node(-1);
        Node curOrigin = head;
        Node curCopy = fakeHead;
        while (curOrigin!=null){
            Node temp = new Node(curOrigin.val);
            oldToNew.put(curOrigin, temp);
            newToOld.put(temp, curOrigin);
            curCopy.next=temp;
            curCopy=curCopy.next;
            curOrigin=curOrigin.next;
        }
        // 重新遍历, 更新 random 引用
        curCopy=fakeHead.next;
        while (curCopy!=null){
            // 拿到 old 节点
            Node old = newToOld.get(curCopy);
            // 拿到 old 节点对应的目标节点
            Node rand = old.random;
            // 拿到 old rand 对应的新节点并更新 random 指向
            curCopy.random= oldToNew.get(rand);
            curCopy=curCopy.next;
        }
        return fakeHead.next;

    }
}
