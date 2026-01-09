package grind75.binary_search;

public class FirstBadVersion {

    public int badVersionStartingPoint(int num , int badVersionStartingPoint){

      BadVersion badVersionStart = new BadVersion(badVersionStartingPoint);
      int low = 1;
      int high = num;

      while(low<high){
          int mid = low + (high-low)/2; //to prevent integer overflow.
          if(badVersionStart.isBadVersion(mid)){
              high = mid;
          }else{
              low = mid+1;
          }
      }
      if(low == high && badVersionStart.isBadVersion(low)) {
          return low;
      }
      return -1;
    }

    public static void main(String[] args){
        int totalVersion = 5;
        int badVersionStartingPoint = 4;
        FirstBadVersion obj = new FirstBadVersion();
        int result = obj.badVersionStartingPoint(totalVersion , badVersionStartingPoint);
        if(result==-1){
            System.out.println("Bad Version is not present");
        }else{
            System.out.println("Bad Version starting from version "+result);
        }
    }
}

class BadVersion {

    int badVersionStarts;

    BadVersion(int badVersionStarts){
        this.badVersionStarts = badVersionStarts;
    }

    public boolean isBadVersion(int num){

        if(num<badVersionStarts){
           return false;
        }
    return true;
    }
}


