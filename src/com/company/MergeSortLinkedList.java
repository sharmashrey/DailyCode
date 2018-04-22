package com.company;




public class MergeSortLinkedList {

    public ListNode sortList(ListNode head) {
        //Base conditions
        if(head == null || head.next==null ){return head;}

        //1. divide the list into two halves
        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //make prev Node point to null to make LL both left & right child seperate
        prev.next= null;

        //2. sort both the halves
        //recurse to sort left
        ListNode l1 = sortList(head);
        //recurse to sort right
        ListNode l2 = sortList(slow);

        //3.Merge both halves
        return merge(l1, l2);
    }
    //sorting step as well
    ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), p = l;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        //if left or right list not completed
        if (l1 != null)
            p.next = l1;
        if (l2 != null)
            p.next = l2;
        return l.next;
    }

}

