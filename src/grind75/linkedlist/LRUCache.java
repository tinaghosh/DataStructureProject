package grind75.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private int capacity ;
    private Map<Integer,Node> cache ;
    private Node head ; //MRU Node
    private Node tail ; //LRU Node

    public LRUCache(int capacity){
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        if(!cache.containsKey(key)){
            return -1;
        }else{
            Node node = cache.get(key);
            //Remove the existing node pointer
            remove(node);
            //write logic to mention this node as most recent Node
            insertAtHead(node);
            return node.value;
        }
    }

    public void put(int key, int value){
        if(cache.containsKey(key)){
            Node dataNode = cache.get(key);
            dataNode.value = value;
            //Remove the existing node pointer
            remove(dataNode);
            //write logic to mention this node as most recent Node
            insertAtHead(dataNode);
        }else {
            if (cache.size() == capacity) {
                //Remove this from map as well
                cache.remove(tail.prev.Key);
                //Remove LRU node pointer
                remove(tail.prev);
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            //write logic to mention this node as most recent Node
            insertAtHead(newNode);
            }
        }

    //remove() method ->  to remove the pointer from LinkedList
    public void remove(Node node){
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }

    //insertAtHead() method ->  to Make the node as MRU Node
    public void insertAtHead(Node node){
       node.next = head.next;
       node.next.prev = node;
       head.next = node;
       node.prev = head;
    }

    public static void main(String[] args){

        String[] operations = {"LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"};
        int[][] inputs = {{2}, {1, 1}, {2, 2}, {1}, {3, 3}, {2}, {4, 4}, {1}, {3}, {4}};

        LRUCache obj = null;

        for(int i=0;i<operations.length;i++){
            if(operations[i].equals("LRUCache")){
                int[] input = inputs[i];
                obj = new LRUCache(input[0]);
            }
            if(operations[i].equals("put")){
                int[] input = inputs[i];
                obj.put(input[0],input[1]);
            }
            if(operations[i].equals("get")){
                int[] input = inputs[i];
                int result = obj.get(input[0]);
                System.out.print(result+" ");
            }
        }
    }

   private static class Node {
        int Key;
        int value;
        Node prev;
        Node next;

       Node(int key , int value){
           this.Key = key;
           this.value = value;
       }
    }
}
