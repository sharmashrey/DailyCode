package com.company;

public class LL_Loop {


    public boolean hasCycle(ListNode root){
        if(root == null) return false;
        ListNode slow = root;
        ListNode fast = root;

        while( fast.next != null && fast.next.next != null){
            if( slow == fast)
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}
