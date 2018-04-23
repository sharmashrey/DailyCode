package com.company;

import java.util.HashMap;

public class LRUCache {
    private class Node {
        Node prev;
        Node next;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> hs = new HashMap<Integer, Node>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }

    public int get(int key) {
        if (!hs.containsKey(key)) {
            return -1;
        }

        // remove current
        Node current = hs.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;

        // move current to tail
        move_to_tail(current);

        return hs.get(key).value;
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            hs.get(key).value = value;
            return;
        }

        if (hs.size() == capacity) {
            hs.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }

        Node insert = new Node(key, value);
        hs.put(key, insert);
        move_to_tail(insert);
    }

    private void move_to_tail(Node current) {
        current.prev = tail.prev;
        tail.prev = current;
        current.prev.next = current;
        current.next = tail;
    }
}
/*




class LRUCache {
    int capacity;
    HashMap<Integer,LinkNode > hm;
    LinkNode head;

    LRUCache(int capacity){
        this.capacity = capacity;
        hm = new HashMap();
        head = null;
    }


    public int get(int key){

      if(hm.containsKey(key)){
           LinkNode current  = hm.get(key);
          //remove node from list
          current.next.prev = current.prev;
          current.prev.next = current.next;
          //update current node
          current.next = head.next;
          current.prev= head;
          //add to head
          head.next =current;

          return hm.get(key).value;
        }
      return -1;
    }

    public void put(int key, int value){

      if(hm.containsKey(key)){
          LinkNode current  = hm.get(key);
          //remove node from list
          if(current.next!=null)current.next.prev = current.prev;
          if(current.prev!=null)current.prev.next = current.next;
          //update current node
          current.next = head.next;
          current.prev= head;
          //add to head
          head.next =current;

      }else{
          if( hm.size() < capacity){
              LinkNode newnode = new LinkNode( key, value, head.next, head);
              hm.put(key,newnode);
              if(head.next!=null) head.next.prev = newnode;
              head.next = newnode;
          }else{
              //A. remove tail
              //1. from LinkList
              LinkNode traversenode = head;
              LinkNode prevtail = head;
              while(traversenode.next != null){
                  prevtail = traversenode;
                  traversenode = traversenode.next;
              }
              prevtail.next = null;
              //2. remove from hashmap
              hm.remove(key);

              //B.add newnode to head
              LinkNode newnode = new LinkNode( key, value, head.next, head);
              hm.put(key,newnode);
              head.next.prev = newnode;
              head.next = newnode;
          }
      }
    }
}

class LinkNode{
    int key ;
    int value;
    LinkNode next;
    LinkNode prev;
    LinkNode(int key, int value, LinkNode next, LinkNode prev){
        this.key = key;
        this.value = value;
        this.next = next ;
        this.prev = prev;
    }
}
*/

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


/*  //ONE SOLUTION
    ConcurrentHashMap hm = new ConcurentHashMap();
    ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
    int capacity =0;

    public LRUCache(int capacity) {
        this.capacity= capacity;
    }

    public int get(int key) {
        return hm.getValue(key);
    }

    public void put(int key, int value) {

        //if hm contains key
        if(hm.get(key) ){
            hm.remove(key);
        }

        while(queue.size() >= capacity){
            queue.poll();

        }
    }*/
