package top150;

import java.util.List;

public class sortList_148 {
    public ListNode sortList(ListNode head) {
        ListNode fakeHead = new ListNode(Integer.MIN_VALUE);
        fakeHead.next = head;
        ListNode sortedLeft = fakeHead;
        ListNode sortedRight = head;
        while (sortedRight!=null){
            ListNode cur = sortedRight.next;
            if (cur==null){
                break;
            }
            if (cur.val>sortedRight.val){
                sortedRight=sortedRight.next;
            }else {
                ListNode leftCur = sortedLeft;
                while (leftCur!=sortedRight){
                    if (leftCur.val==cur.val||(leftCur.val<cur.val&&leftCur.next.val>cur.val)){
                        sortedRight.next=cur.next;
                        cur.next=leftCur.next;
                        leftCur.next=cur;
                        break;
                    }
                    leftCur=leftCur.next;
                }
            }
        }
        return fakeHead.next;

    }
    public static void main(String[] args){
        sortList_148 s = new sortList_148();
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        System.out.println(s.sortList(head));
    }
}
