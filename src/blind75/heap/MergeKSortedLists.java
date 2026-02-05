package blind75.heap;

import blind75.linkedlist.LinkNode;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {

    public LinkNode mergeKSortedLists(List<LinkNode> listsOfLinkedList){

        LinkNode head = new LinkNode(1);
        Queue<Integer> minHeap = new PriorityQueue<>();

        for(LinkNode list : listsOfLinkedList ){
            while(list!=null) {
                minHeap.add(list.data);
                list = list.nextNode;
            }
        }
        LinkNode current = head;
        while(!minHeap.isEmpty()){
           current.nextNode = new LinkNode(minHeap.poll());
           current = current.nextNode;
        }
        return head.nextNode;
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
        int[][] lists = {{1,4,5},{1,3,4},{2,6}};

        LinkNode list1 = new LinkNode(lists[0][0]);
        list1.nextNode =  new LinkNode(lists[0][1]);
        list1.nextNode.nextNode =  new LinkNode(lists[0][2]);

        LinkNode list2 = new LinkNode(lists[1][0]);
        list2.nextNode =  new LinkNode(lists[1][1]);
        list2.nextNode.nextNode =  new LinkNode(lists[1][2]);

        LinkNode list3 = new LinkNode(lists[2][0]);
        list3.nextNode =  new LinkNode(lists[2][1]);

        List<LinkNode> listsOfLinkedList = new ArrayList<>();
        listsOfLinkedList.add(list1);
        listsOfLinkedList.add(list2);
        listsOfLinkedList.add(list3);

        MergeKSortedLists obj = new MergeKSortedLists();
        LinkNode result = obj.mergeKSortedLists(listsOfLinkedList);
        obj.printLinkedList(result);
    }
}
