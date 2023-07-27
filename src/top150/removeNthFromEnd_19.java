package top150;

public class removeNthFromEnd_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next=head;
        ListNode cur = fakeHead;

        int length = 0;
        while (cur!=null){
            length+=1;
            cur=cur.next;
        }
        int target=length-n-1;
        cur=fakeHead;
        for (int i=0; i<target; i++){
            cur=cur.next;
        }
        cur.next=cur.next.next;
        return fakeHead.next;
    }
}
