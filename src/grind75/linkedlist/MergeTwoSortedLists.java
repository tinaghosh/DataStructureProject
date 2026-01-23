package grind75.linkedlist;


public class MergeTwoSortedLists {

    public LinkNode mergeTwoLists(LinkNode list1,LinkNode list2){

        LinkNode mergeList  = null;

        if(list1==null && list2!=null){
            return list2;
        }else if (list1!=null && list2==null){
            return list1;
        }else {

            while (list1 != null && list2 != null) {

                if (list1.data < list2.data) {
                    if (mergeList == null) {
                        mergeList = new LinkNode(list1.data);
                    } else {
                        LinkNode currentNode = mergeList;
                        while (currentNode.nextNode != null) {
                            currentNode = currentNode.nextNode;
                        }
                        currentNode.nextNode = new LinkNode(list1.data);
                    }
                    list1 = list1.nextNode;

                } else if (list1.data > list2.data) {

                    if (mergeList == null) {
                        mergeList = new LinkNode(list2.data);
                    } else {
                        LinkNode currentNode = mergeList;
                        while (currentNode.nextNode != null) {
                            currentNode = currentNode.nextNode;
                        }
                        currentNode.nextNode = new LinkNode(list2.data);
                    }
                    list2 = list2.nextNode;

                } else {

                    if (mergeList == null) {
                        mergeList = new LinkNode(list1.data);
                    } else {
                        LinkNode currentNode = mergeList;
                        while (currentNode.nextNode != null) {
                            currentNode = currentNode.nextNode;
                        }
                        currentNode.nextNode = new LinkNode(list1.data);
                    }
                    list1 = list1.nextNode;

                    LinkNode currentNode = mergeList;
                    while (currentNode.nextNode != null) {
                        currentNode = currentNode.nextNode;
                    }
                    currentNode.nextNode = new LinkNode(list2.data);
                    list2 = list2.nextNode;
                }
            }
            if (list1 != null && list2 == null) {
                LinkNode currentNode = mergeList;
                while (currentNode.nextNode != null) {
                    currentNode = currentNode.nextNode;
                }
                currentNode.nextNode =  list1;
            }

            if (list1 == null && list2 != null) {
                LinkNode currentNode = mergeList;
                while (currentNode.nextNode != null) {
                    currentNode = currentNode.nextNode;
                }
                currentNode.nextNode = list2;
            }
        }
       return mergeList;
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

        int[] listArray1 = {1,2,4,5};
        int[] listArray2 = {1,3,4,6,7};

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
        LinkNode result = obj.mergeTwoLists(list1,list2);
        printLinkedList(result);

    }
}
