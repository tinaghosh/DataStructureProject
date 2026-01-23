package blind75.linkedlist;

public class LinkNode {
    public int data;
    public LinkNode nextNode;

    LinkNode(){
    }

    public LinkNode(int data){
       this.data = data;
       this.nextNode = null;
    }

    public LinkNode(int data, LinkNode node){
        this.data = data;
        this.nextNode = node;
    }


}
