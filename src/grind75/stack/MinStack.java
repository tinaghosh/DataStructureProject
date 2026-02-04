package grind75.stack;

import java.util.Stack;

public class MinStack {

    CustomStackNode head = null;

    public MinStack(){

    }

    public void push(int i){
      if(head==null){
          head = new CustomStackNode(i,i,null);
      }else{
          head = new CustomStackNode(i,Math.min(i,head.minValue),head);
      }
    }

    public void pop(){
       head = head.nextNode;
    }

    public int top(){
     return head.value;
    }

    public int getMin(){
      return head.minValue;
    }


    public static void main(String[] args){
       String[] operations = {"MinStack","push","push","push","getMin","pop","top","getMin"};
       int[][] inputs = {{},{-2},{0},{-3},{},{},{},{}};

        MinStack obj = null;

       for(int i=0;i<operations.length;i++){
           if(operations[i].equals("MinStack")){
               obj = new MinStack();
           } else if (operations[i].equals("push")) {
               int[] input = inputs[i];
               obj.push(input[0]);
           } else if (operations[i].equals("getMin")) {
               int result = obj.getMin();
               System.out.print(result+" ");
           } else if (operations[i].equals("pop")) {
               obj.pop();
           } else if (operations[i].equals("top")) {
               int result = obj.top();
               System.out.print(result+" ");
           }
       }
    }

    private class CustomStackNode{
        int value;
        int minValue;
        CustomStackNode nextNode;

        public CustomStackNode(int value,int minValue,CustomStackNode nextNode ){
            this.value = value;
            this.minValue = minValue;
            this.nextNode = nextNode;
        }
    }
}
