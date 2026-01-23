package blind75.linkedlist;

public class ReorderList {

    public LinkNode reorderLinkedList(LinkNode head){

        LinkNode fastPointer = head;
        LinkNode slowPointer = head;

        while(fastPointer!=null && fastPointer.nextNode!=null){
            slowPointer = slowPointer.nextNode;
            fastPointer = fastPointer.nextNode.nextNode;
        }
        LinkNode midNode = slowPointer;

        LinkNode prev = null;
        LinkNode current = midNode.nextNode;

        while(current!=null){
            LinkNode temp = current.nextNode;
            current.nextNode= prev;
            prev = current;
            current = temp;
        }

        LinkNode secondPart = prev;
        LinkNode firstPart = head;
        midNode.nextNode = null;

        printLinkedList(secondPart);
        System.out.println();
        printLinkedList(firstPart);
        System.out.println();

        while(firstPart!=null && secondPart!=null){
            LinkNode firstPartTemp = firstPart.nextNode;
            LinkNode secondPartTemp = secondPart.nextNode;
            firstPart.nextNode = secondPart;
            secondPart.nextNode = firstPartTemp;
            firstPart = firstPartTemp;
            secondPart = secondPartTemp;
        }
        return head;
    }

    public static void printLinkedList(LinkNode head){

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
        int[] headArray = {1,2,3,4,5};

        LinkNode head = new LinkNode(headArray[0]);
        head.nextNode =  new LinkNode(headArray[1]);
        head.nextNode.nextNode =  new LinkNode(headArray[2]);
        head.nextNode.nextNode.nextNode =  new LinkNode(headArray[3]);
        head.nextNode.nextNode.nextNode.nextNode =  new LinkNode(headArray[4]);
        //head.nextNode.nextNode.nextNode.nextNode.nextNode =  new LinkNode(headArray[5]);

        ReorderList obj = new ReorderList();
        LinkNode result = obj.reorderLinkedList(head);
        if(result!=null){
            printLinkedList(result);
        }
    }
}
