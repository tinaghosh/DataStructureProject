package blind75.binary;

import java.util.Arrays;

public class CountingBits {

    public int[] noOf1bitsInEachNumber(int num) {
        int[] result = new int[num + 1];

        if (num == 0) {
            return result;
        }
        result[0] = 0;

        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0) {
                result[i] = result[i / 2];
            } else {
                result[i] = result[i / 2] + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        CountingBits obj = new CountingBits();
        int[] result = obj.noOf1bitsInEachNumber(n);
        Arrays.stream(result).forEach(e -> System.out.print(e + " "));
    }
}
