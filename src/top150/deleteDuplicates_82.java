package top150;

public class deleteDuplicates_82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next=head;
        ListNode left = fakeHead;
        ListNode right = head;
        while (left!=null&&right!=null){
            // 将 right 移动到合适的位置
            boolean moved = false;
            while (right.next!=null&&right.next.val==right.val){
                right=right.next;
                moved=true;
            }
            if (moved){
                right=right.next;
            }
            left.next=right;
            if (!moved) {
                left = right;
                right = left.next;
            }
        }
        return fakeHead.next;


    }
}
