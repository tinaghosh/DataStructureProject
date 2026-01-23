package grind75.linkedlist;



public class ReverseALinkedList {
    public LinkNode reverseLinkedList(LinkNode head){

        LinkNode current  = head;
        LinkNode prev  = null ;

        while(current!= null){

            LinkNode temp = current.nextNode;
            current.nextNode = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    public void printLinkedList(LinkNode head){

        LinkNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data);
            if (currentNode.nextNode != null) {
                System.out.print(" ---> ");
            }
            currentNode = currentNode.nextNode;
        }
    }

    public static void main(String[] args){

        int[] headArray  = {1,2,3,4,5};

        LinkNode head = new LinkNode(headArray[0]);
        head.nextNode = new LinkNode(headArray[1]);
        head.nextNode.nextNode = new LinkNode(headArray[2]);
        head.nextNode.nextNode.nextNode = new LinkNode(headArray[3]);
        head.nextNode.nextNode.nextNode.nextNode = new LinkNode(headArray[4]);

        ReverseALinkedList obj = new ReverseALinkedList();
        obj.printLinkedList(head);
        LinkNode result = obj.reverseLinkedList(head);
        System.out.println("\nReverse LinkedList is : ");
        obj.printLinkedList(result);
    }
}
