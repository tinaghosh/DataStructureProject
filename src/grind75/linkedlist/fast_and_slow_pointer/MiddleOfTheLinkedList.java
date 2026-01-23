package grind75.linkedlist.fast_and_slow_pointer;

import grind75.linkedlist.LinkNode;

public class MiddleOfTheLinkedList {

    public LinkNode middleNode(LinkNode head){

        LinkNode slowPointer = head;
        LinkNode fastPointer = head;

        while(fastPointer!=null && fastPointer.nextNode!=null){
            slowPointer = slowPointer.nextNode;
            fastPointer = fastPointer.nextNode.nextNode;
        }

      return slowPointer;
    }

    public static void main(String[] args){

        int[] headArray = {1,2,3,4,5,6};

        LinkNode head = new LinkNode(headArray[0]);
        head.nextNode = new LinkNode(headArray[1]);
        head.nextNode.nextNode = new LinkNode(headArray[2]);
        head.nextNode.nextNode.nextNode = new LinkNode(headArray[3]);
        head.nextNode.nextNode.nextNode.nextNode = new LinkNode(headArray[4]);
        head.nextNode.nextNode.nextNode.nextNode.nextNode = new LinkNode(headArray[5]);

        MiddleOfTheLinkedList obj = new MiddleOfTheLinkedList();
        LinkNode result = obj.middleNode(head);
        if(result!=null){
            System.out.println("Middle Node of the linked list is : "+result.data);
        }
    }
}
