package neetcode150.binarysearch;

public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {

        int maxBananasInOnePile = Integer.MIN_VALUE;
        int numberOfBananaCanEatPerHour = 0;

        for (int pile : piles) {
            maxBananasInOnePile = Math.max(maxBananasInOnePile, pile);
        }

        int left = 1;
        int right = maxBananasInOnePile;

        while (left <= right) {
            numberOfBananaCanEatPerHour = left + (right - left) / 2;
            if (calculateSpeed(piles, numberOfBananaCanEatPerHour) <= h) {
                right = numberOfBananaCanEatPerHour - 1;
            } else {
                left = numberOfBananaCanEatPerHour + 1;
            }
        }
        return left;
    }

    public long calculateSpeed(int[] piles, int numberOfBananaCanEatPerHour) {
        //System.out.println( "Banana -> "+numberOfBananaCanEatPerHour);
        long hours = 0;

        for (int pile : piles) {
            hours = hours + (pile / numberOfBananaCanEatPerHour);
            if (pile % numberOfBananaCanEatPerHour > 0) {
                hours++;
            }
        }
        //System.out.println("Times-> "+hours);
        return hours;
    }

    public static void main(String[] args) {
        int[] piles ={312884470};// {30, 11, 23, 4, 20};
        int hours = 312884469;

        KokoEatingBananas obj = new KokoEatingBananas();
        int result = obj.minEatingSpeed(piles, hours);
        System.out.print("Number Of Bananas KOKO Can Eat Per Hour is -> " + result);
    }
}
