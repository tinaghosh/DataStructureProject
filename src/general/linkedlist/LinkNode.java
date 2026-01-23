package general.linkedlist;

public class LinkNode {
    int data;
    LinkNode nextNode;

    LinkNode(){
    }

    LinkNode(int data){
       this.data = data;
       this.nextNode = null;
    }

    LinkNode(int data, LinkNode node){
        this.data = data;
        this.nextNode = node;
    }

}
