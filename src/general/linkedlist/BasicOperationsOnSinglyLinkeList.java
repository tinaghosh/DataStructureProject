package general.linkedlist;

public class BasicOperationsOnSinglyLinkeList {

    public void printLinkedList(LinkNode head){
        LinkNode currentNode = head;

        while(currentNode!=null){
            System.out.print(currentNode.data);
            if(currentNode.nextNode!=null){
                System.out.print(" ---> ");
            }
            currentNode=currentNode.nextNode;
        }
    }

    public LinkNode insertAtBegining(LinkNode head,int data){
        LinkNode currentNode = head;
        LinkNode newNode = new LinkNode(data);
        newNode.nextNode = currentNode;
        head = newNode;

        return head;
    }

    public LinkNode insertAtEnd(LinkNode head,int data){
        LinkNode currentNode = head;
        LinkNode newNode = new LinkNode(data);

        while(currentNode.nextNode!=null){
            currentNode=currentNode.nextNode;
        }
        currentNode.nextNode=newNode;
        return head;
    }

    public LinkNode insertAtSpecificPosition(LinkNode head,int data,int position){
        LinkNode currentNode = head;
        LinkNode newNode = new LinkNode(data);

       for(int i=1;i<position-1;i++){
         currentNode = currentNode.nextNode;
        }
        newNode.nextNode = currentNode.nextNode;
        currentNode.nextNode=newNode;
        return head;
    }

    public boolean searchNode(LinkNode head,int data){
        LinkNode currentNode = head;

        while(currentNode!=null){
            if(currentNode.data==data){
                return true;
            }
            currentNode=currentNode.nextNode;
        }
        return false;
    }

    public LinkNode deleteAtBegining(LinkNode head){

        head = head.nextNode;
        return head;
    }

    public LinkNode deleteAtEnd(LinkNode head){
        LinkNode currentNode = head;

        while(currentNode.nextNode.nextNode!=null){
            currentNode=currentNode.nextNode;
        }
        currentNode.nextNode=null;
        return head;
    }

    public LinkNode deleteAtSpecificPosition(LinkNode head,int position){
        LinkNode currentNode = head;

        for(int i=1;i<position-1;i++){
            currentNode = currentNode.nextNode;
        }
        currentNode.nextNode = currentNode.nextNode.nextNode;
        return head;
    }

    public static void main(String[] args){

        LinkNode head = new LinkNode(10);
        head.nextNode = new LinkNode(20);
        head.nextNode.nextNode = new LinkNode(30);
        head.nextNode.nextNode.nextNode = new LinkNode(40);

        BasicOperationsOnSinglyLinkeList obj = new BasicOperationsOnSinglyLinkeList();
        System.out.println("Initial LinkedList : ");
        obj.printLinkedList(head);

        LinkNode headAfterInsertAtBegining = obj.insertAtBegining(head, 5);
        System.out.println("\nAfter inserting node at the begining");
        obj.printLinkedList(headAfterInsertAtBegining);

        LinkNode headAfterInsertAtEnd = obj.insertAtEnd(headAfterInsertAtBegining, 45);
        System.out.println("\nAfter inserting node at the end");
        obj.printLinkedList(headAfterInsertAtEnd);

        LinkNode headAfterInsertAtSpecificPosition = obj.insertAtSpecificPosition(headAfterInsertAtEnd, 25,4);
        System.out.println("\nAfter inserting node at the Specific Position");
        obj.printLinkedList(headAfterInsertAtEnd);

        boolean searchNode = obj.searchNode(headAfterInsertAtSpecificPosition, 25);
        if(searchNode){
            System.out.println("\nData is present in the LinkedList");
        }else{
            System.out.println("\nData is not present in the LinkedList");
        }

        LinkNode headAfterDeleteAtBegining = obj.deleteAtBegining(headAfterInsertAtSpecificPosition);
        System.out.println("\nAfter deleting node at the begining");
        obj.printLinkedList(headAfterDeleteAtBegining);

        LinkNode headAfterDeleteAtEnd = obj.deleteAtEnd(headAfterDeleteAtBegining);
        System.out.println("\nAfter deleting node at the end");
        obj.printLinkedList(headAfterDeleteAtEnd);

        LinkNode headAfterDeleteAtSpecificPosition = obj.deleteAtSpecificPosition(headAfterDeleteAtEnd,3);
        System.out.println("\nAfter deleting node at the Specific Position");
        obj.printLinkedList(headAfterDeleteAtSpecificPosition);

    }
}
