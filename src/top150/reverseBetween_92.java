package top150;

import java.util.List;
 class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
public class reverseBetween_92 {


    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode fakeHead = new ListNode();
        fakeHead.next=head;
        ListNode preCursor = fakeHead;
        ListNode cursor = preCursor;
        int count=0;
        // 确定好 cursor
        while (count<left){
            preCursor=cursor;
            cursor=cursor.next;
            count++;
        }
        // 开始反转
        while (count<right){
            ListNode oldNext = cursor.next;
            cursor.next=oldNext.next;
            oldNext.next=preCursor.next;
            preCursor.next=oldNext;
            count++;
        }
        return fakeHead.next;
    }

    public static void main(String[] args){
        reverseBetween_92 r = new reverseBetween_92();
        ListNode head = new ListNode(-1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        r.reverseBetween(node1,2,4);
    }
}
