package top150;

public class sortList_148_2 {
    public ListNode sortList(ListNode head) {
        return sort(head, null);
    }

    public ListNode sort(ListNode head, ListNode tail){
        if (head==null){
            return null;
        }
        if (head.next==tail){
            //需要变成一个单独节点返回
            head.next=null;
            return head;
        }
        ListNode fast=head, slow=head;
        while (fast!=tail){
            fast=fast.next;
            slow=slow.next;
            if (fast!=tail){
                fast=fast.next;
            }
        }
        ListNode mid = slow;
        ListNode left = sort(head, mid);
        ListNode right = sort(mid, tail);
        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right){
        ListNode leftCur = left;
        ListNode rightCur = right;
        ListNode resHead = new ListNode(-1);
        ListNode resCur = resHead;
        while (leftCur!=null&&rightCur!=null){
            if (leftCur.val<=rightCur.val){
                resCur.next=leftCur;
                leftCur=leftCur.next;
            }else {
                resCur.next=rightCur;
                rightCur=rightCur.next;
            }
            resCur=resCur.next;
        }
        //处理left
        while (leftCur!=null){
            resCur.next=leftCur;
            resCur=resCur.next;
            leftCur=leftCur.next;
        }
        //处理right
        while (rightCur!=null){
            resCur.next=rightCur;
            resCur=resCur.next;
            rightCur=rightCur.next;
        }
        return resHead.next;
    }
}
