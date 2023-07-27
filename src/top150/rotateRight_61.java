package top150;

public class rotateRight_61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next=head;
        ListNode cur = fakeHead;
        // 记录链表长度并获得 tail 指针
        ListNode tail = null;
        int len =0;
        while (cur!=null){
            len++;
            tail=cur;
            cur=cur.next;
        }
        // 计算真实 k
        k%=len;
        // 获得截断位置
        ListNode cut = null;
        cur=fakeHead;
        int count=0;
        while (cur!=null){
            if (count==len-k){
                cut = cur;
                break;
            }
            count++;
            cur=cur.next;
        }
        tail.next=fakeHead.next;
        fakeHead.next=cut.next;
        cut.next=null;
        return fakeHead.next;
    }
}
