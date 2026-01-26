package grind75.array;

public class MajorityElement {
    public int findMajorityElement(int[] arr){ //Boyer-Moore Algorithm
      int maxElement = arr[0];
      int count = 0;
      for(int i=0;i<arr.length;i++){
          if(maxElement==arr[i]){
              count++;
          }else{
             count--;
             if(count==-1){
                 maxElement = arr[i];
                 count = 1;
             }
          }
      }
      return maxElement;
    }
    public static void main(String args[]){
        int[] nums = {2,2,1,1,1,2,2};
        MajorityElement obj = new MajorityElement();
        int result = obj.findMajorityElement(nums);
        System.out.println("Majority Element in the array is :"+result);
    }
}


