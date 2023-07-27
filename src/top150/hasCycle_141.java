package top150;

import java.util.List;

public class hasCycle_141 {
    /**
     * Definition for singly-linked list.
     */
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head==null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        boolean begin = true;
        while (fast!=null&&slow!=null&&fast.next!=null){
            if (slow==fast&&!begin){
                return true;
            }
            slow=slow.next;
            fast=fast.next.next;
            begin=false;
        }
        return false;
    }
}
