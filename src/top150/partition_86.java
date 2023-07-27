package top150;

public class partition_86 {
    public ListNode partition(ListNode head, int x) {
        ListNode fakeHead = new ListNode(-1000);
        fakeHead.next=head;
        ListNode pre = fakeHead;
        ListNode cur = pre.next;
        while (cur!=null&&pre!=null){
            if (cur.val>=x){
                break;
            }
            pre= pre.next;
            cur=cur.next;
        }
        if (cur==null){
            return fakeHead.next;
        }
        // 第二次遍历
        ListNode secondPre = cur;
        ListNode secondCur = cur.next;
        while (secondCur!=null&&secondPre!=null){
            if (secondCur.val<x){
                // 暂存右侧节点的下一个
                ListNode temRight = secondCur.next;
                // 从右侧节点剔除
                secondPre.next=secondCur.next;
                // 加入到左侧
                pre.next=secondCur;
                secondCur.next=cur;
                // 更新左侧的 pre
                pre = secondCur;
                secondCur=temRight;
            }else {
                secondPre=secondPre.next;
                secondCur=secondCur.next;
            }

        }
        return fakeHead.next;
    }
    public static void main(String[] args){
        partition_86 p = new partition_86();
        ListNode h=new ListNode(1);
        h.next=new ListNode(4);
        h.next.next=new ListNode(3);
        h.next.next.next=new ListNode(2);
        h.next.next.next.next=new ListNode(5);
        h.next.next.next.next.next=new ListNode(2);
        p.partition(h,3);
    }
}
