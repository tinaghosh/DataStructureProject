package neetcode250.binarysearch;

public class CapacityToShipPackagesWithInDdays {
    public int shipWithinDays(int[] weights, int days) {

        int left = 0;
        int right = 0;

        for(int i=0 ;i<weights.length;i++){
            left = Math.max(weights[i],left);
            right = right + weights[i];
        }

        while(left<=right){
            int mid = left + (right-left)/2;
            int dayRequired = daysRequired(weights,mid);

            if(dayRequired <= days){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

    public int daysRequired(int[] weights, int capacity){
        int load = 0;
        int days = 1;

        for(int i =0;i<weights.length;i++){
            if(load + weights[i]> capacity){
                days = days+1;
                load = weights[i];
            }else{
                load = load + weights[i];
            }
        }
        return days;
    }

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        CapacityToShipPackagesWithInDdays obj = new CapacityToShipPackagesWithInDdays();
        int result = obj.shipWithinDays(weights,days);
        System.out.println("Minimum Capacity -> "+result);
    }
}
