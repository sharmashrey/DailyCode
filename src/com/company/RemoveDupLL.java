package com.company;

public class RemoveDupLL {

    public static void main(String[] args) {

        ListNode start = new ListNode(10);
        start.next = new ListNode(10);
        start.next.next = new ListNode(11);
        start.next.next.next = new ListNode(11);
        start.next.next.next.next = new ListNode(12);
        start.next.next.next.next.next = new ListNode(12);
        start.next.next.next.next.next.next = new ListNode(15);

        System.out.println("Linked list before removing duplicates :");
        printList(start);

        removeDuplicate(start);
        System.out.println("\nLinked list after removing duplicates :");
        printList(start);
    }

    public static void removeDuplicate(ListNode root) {
        ListNode curr = root;
        while(curr != null ){
            if(curr.next == null){
                break;
            }
            if(curr.val == curr.next.val){
                curr.next = curr.next.next;
            }else{
                // only increment current value if unique
                curr = curr.next;
            }
        }
    }


    public static void printList(ListNode root) {
        while(root != null){
            System.out.println(root.val);
            root = root.next;
        }

    }
}