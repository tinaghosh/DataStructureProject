package blind75.linkedlist;

public class RemoveNthNodeFromEndOfList {

    public LinkNode removeNthNodeFromEndOfList(LinkNode head , int position){

        int size = size(head);
        if(size<=1){
           head = null;
        }else {
            int deleteNodePosition = (size - position) + 1;
            if(deleteNodePosition == 1){
                head = head.nextNode;
            }else {

                LinkNode currentNode = head;
                for (int i = 1; i < deleteNodePosition - 1; i++) {
                    currentNode = currentNode.nextNode;
                }
                System.out.println(currentNode.data);
                if(currentNode!=null && currentNode.nextNode!=null) {
                    currentNode.nextNode = currentNode.nextNode.nextNode;
                }
            }
        }
       return head;
    }

    public int size(LinkNode head){

        int size =0;
        LinkNode current =head;

        if(head==null){
            return 0;
        }else{
            while(current!=null){
                size++;
                current = current.nextNode;
            }
            return size;
        }
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
        int n = 2;

        LinkNode head = new LinkNode(headArray[0]);
        head.nextNode = new LinkNode(headArray[1]);
        head.nextNode.nextNode = new LinkNode(headArray[2]);
        head.nextNode.nextNode.nextNode = new LinkNode(headArray[3]);
        head.nextNode.nextNode.nextNode.nextNode = new LinkNode(headArray[4]);

        RemoveNthNodeFromEndOfList obj = new RemoveNthNodeFromEndOfList();
        LinkNode result = obj.removeNthNodeFromEndOfList(head,n);
        printLinkedList(result);


    }
}
