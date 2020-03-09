package com.company;

/*
* class Node{ int nodeId,int nodeParentId} is given.
Input : List&lt;Node&gt;
Output:Tree

*/

import java.util.*;

public class GenerateTree{

    public static void main(String[] args){

        ArrayList<Node> nodeList = new ArrayList();
        Node node4 = new Node(4, 2);
        Node node5 = new Node(5, 2);
        Node node2 = new Node(2, 6);
        Node node6 = new Node(6, 3);
        Node node7 = new Node(7, 3);
        Node node3 = new Node(3, 0);

        nodeList.add(node7);
        nodeList.add(node3);
        nodeList.add(node6);
        nodeList.add(node5);
        nodeList.add(node4);
        nodeList.add(node2);

        genTree(nodeList);

        }

        public static void genTree( ArrayList<Node> nodeList ){

            HashMap<Integer,ArrayList<Integer>>  hm = new HashMap<>();

            for( int i =0; i < nodeList.size() ; i++){

                Node current = nodeList.get(i);
                int parent = current.nodeParentId;
                int currval = current.nodeId;

                //create key value pair if not present in HashMap
                if(!hm.containsKey( parent)){
                    ArrayList<Integer> templist = new ArrayList<>();
                    templist.add(currval);
                    hm.put(parent , templist );
                }else {
                    //key present and found new child
                    ArrayList<Integer> templist=  hm.get(parent);
                    templist.add(currval);
                    hm.put(parent, templist);
                }
            }

            //get root\
            Node rootNode =null;
            for (Node temp : nodeList) {
                if( temp.nodeParentId == 0 ){
                    rootNode = temp;
                }
            }

            // queue to traverse arraylist
            PriorityQueue<Integer> qu = new PriorityQueue<>();
            qu.add(rootNode.nodeId);

            while(!qu.isEmpty()){
                Integer currentNode = qu.poll();
                //print out currentNode
                System.out.print(currentNode);
                int numchildren=0;
                if( hm.get(currentNode) != null)
                    numchildren= hm.get(currentNode).size();

                for(int children =0; children < numchildren; children++){
                    qu.offer( hm.get( currentNode ).get(children));

                }

            }


        }

}

