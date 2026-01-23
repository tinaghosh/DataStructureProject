package blind75.linkedlist.fast_and_slow_pointer;

import blind75.linkedlist.LinkNode;

public class DetectCycleInALinkedList {

    public boolean detectCycle(LinkNode head){

        LinkNode fastPointer = head;
        LinkNode slowPointer = head;

        while(slowPointer!=null && fastPointer!=null && fastPointer.nextNode!=null){
            slowPointer = slowPointer.nextNode;
            fastPointer = fastPointer.nextNode.nextNode;

            if(slowPointer==fastPointer){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){

        int[] headArray1 = {3,2,0,-4};
        int pos1 = 1;

        LinkNode head1 = new LinkNode(headArray1[0]);
        head1.nextNode = new LinkNode(headArray1[1]);
        head1.nextNode.nextNode = new LinkNode(headArray1[2]);
        head1.nextNode.nextNode.nextNode = new LinkNode(headArray1[3]);
        head1.nextNode.nextNode.nextNode.nextNode =  head1.nextNode;

        int[] headArray2 = {1};
        int pos2 = -1;
        LinkNode head2 = new LinkNode(headArray2[0]);

        DetectCycleInALinkedList obj = new DetectCycleInALinkedList();

        boolean result1 = obj.detectCycle(head1);
        if(result1){
            System.out.println("There is cycle present in the linkedlist");
        }else{
            System.out.println("There is no cycle present in the linkedlist");
        }

        boolean result2 = obj.detectCycle(head2);
        if(result2){
            System.out.println("There is cycle present in the linkedlist");
        }else{
            System.out.println("There is no cycle present in the linkedlist");
        }

    }
}
