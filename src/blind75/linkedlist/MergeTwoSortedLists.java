package blind75.linkedlist;


public class MergeTwoSortedLists {

    public LinkNode mergeTwoLists(LinkNode list1, LinkNode list2) {

        LinkNode mergeList = null;

        if (list1 != null && list2 == null) {
            return list1;
        }
        if (list1 == null && list2 != null) {
            return list2;
        }
        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                mergeList = insertAtEnd(mergeList, list1.data);
                list1 = list1.nextNode;
            } else if (list1.data > list2.data) {
                mergeList = insertAtEnd(mergeList, list2.data);
                list2 = list2.nextNode;
            } else {
                mergeList = insertAtEnd(mergeList, list1.data);
                mergeList = insertAtEnd(mergeList, list2.data);
                list1 = list1.nextNode;
                list2 = list2.nextNode;
            }
        }
        while (list1 != null) {
            mergeList = insertAtEnd(mergeList, list1.data);
            list1 = list1.nextNode;
        }
        while (list2 != null) {
            mergeList = insertAtEnd(mergeList, list2.data);
            list2 = list2.nextNode;
        }
        return mergeList;
    }

    public LinkNode insertAtEnd(LinkNode head, int data) {

        LinkNode current = head;
        LinkNode newNode = new LinkNode(data);

        if (head == null) {
            head = newNode;
        } else {
            while (current.nextNode != null) {
                current = current.nextNode;
            }
            current.nextNode = newNode;
        }
        return head;
    }

    public static void printLinkedList(LinkNode head) {

        LinkNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data);
            if (currentNode.nextNode != null) {
                System.out.print(" ---> ");
            }
            currentNode = currentNode.nextNode;
        }
    }

    public static void main(String[] args) {

        int[] listArray1 = {1, 2, 4, 5};
        int[] listArray2 = {1, 3, 4, 6, 7};

        LinkNode list1 = new LinkNode(listArray1[0]);
        list1.nextNode = new LinkNode(listArray1[1]);
        list1.nextNode.nextNode = new LinkNode(listArray1[2]);
        list1.nextNode.nextNode.nextNode = new LinkNode(listArray1[3]);

        LinkNode list2 = new LinkNode(listArray2[0]);
        list2.nextNode = new LinkNode(listArray2[1]);
        list2.nextNode.nextNode = new LinkNode(listArray2[2]);
        list2.nextNode.nextNode.nextNode = new LinkNode(listArray2[3]);
        list2.nextNode.nextNode.nextNode.nextNode = new LinkNode(listArray2[4]);

        MergeTwoSortedLists obj = new MergeTwoSortedLists();
        LinkNode result = obj.mergeTwoLists(list1, list2);
        printLinkedList(result);

    }
}
