package top150;

public class mergeKLists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        return sort(lists,0,lists.length-1);

    }
    public ListNode sort(ListNode[] listNodes, int left, int right){
        if (left>=listNodes.length||right>=listNodes.length||left<0||right<0){
            return null;
        }
        if (left==right){
            return listNodes[left];
        }
        int mid = (left+right)/2;
        ListNode leftSorted = sort(listNodes, left, mid);
        ListNode rightSorted = sort(listNodes, mid+1, right);
        return merge(leftSorted, rightSorted);
    }

    public ListNode merge(ListNode l1, ListNode l2){
        ListNode fakeHead = new ListNode(-1);
        ListNode cur0 = fakeHead;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while (cur1!=null&&cur2!=null){
            if (cur1.val>=cur2.val){
                cur0.next=cur2;
                cur2=cur2.next;
            }else {
                cur0.next=cur1;
                cur1=cur1.next;
            }
            cur0=cur0.next;
        }
        if (cur1!=null){
            cur0.next=cur1;
        }else {
            cur0.next=cur2;
        }
        return fakeHead.next;
    }

}
