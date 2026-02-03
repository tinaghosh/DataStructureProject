package grind75.stack;


import java.util.Stack;

public class ImplementQueueUsingStacks {

     Stack<Integer> s1 = null;
     Stack<Integer> s2 = null;

     public ImplementQueueUsingStacks(){
          s1 = new Stack();
          s2 = new Stack();
     }
     public void push(int[] input){
         for(int i=0;i<input.length;i++){
             s1.push(input[i]);
         }
     }

     public int peek(){
         if(!s2.isEmpty()){
             return s2.peek();
         }else {
             while (!s1.isEmpty()) {
                 int popValue = s1.pop();
                 s2.push(popValue);
             }
             return s2.peek();
         }
     }

     public int pop(){
         if(!s2.isEmpty()){
             return s2.pop();
         }else{
             while(!s1.isEmpty()) {
                 int popValue = s1.pop();
                 s2.push(popValue);
             }
             return s2.pop();
         }
     }

     public boolean isEmpty(){
         if(Math.max(s1.size(), s2.size())==0){
             return true;
         }
         return false;
     }


    public static void main(String[] args){
        String[] operations = {"MyQueue","push","push","push","push","pop","push","pop","pop","pop","pop"};
        int[][] inputsForOperations = {{},{1},{2},{3},{4},{},{5},{},{},{},{}};
        ImplementQueueUsingStacks obj = null;

        for(int i =0;i<operations.length;i++) {

            if(operations[i].equals("MyQueue")){
                obj = new ImplementQueueUsingStacks();
            }else if(operations[i].equals("push")){
                obj.push(inputsForOperations[i]);
            }else if(operations[i].equals("peek")){
                int result = obj.peek();
                System.out.println(result);
            }else if(operations[i].equals("pop")){
                int result = obj.pop();
                System.out.println(result);
            }else if(operations[i].equals("empty")){
                boolean result = obj.isEmpty();
                System.out.println(result);
            }
        }
    }
}
