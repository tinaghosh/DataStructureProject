package grind75.stack;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public int findMaxAreaInHistogram(int[] heights) {

        int maxArea = 0;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(0, heights[0]));

        for (int i = 1; i < heights.length; i++) {
            Pair prev = stack.peek();
            if (prev.height < heights[i]) {
                stack.push(new Pair(i, heights[i]));
            } else {
                Pair poppedPair = null;
                while (!stack.isEmpty() && stack.peek().height >= heights[i]) {
                    poppedPair = stack.pop();
                    maxArea = Math.max(maxArea, (poppedPair.height * (i - poppedPair.startIndex)));
                }
                if(poppedPair!=null)
                    stack.push(new Pair(poppedPair.startIndex,heights[i]));
            }
        }

        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            maxArea = Math.max(maxArea, (p.height * (heights.length - p.startIndex)));
        }
        return maxArea;
    }

    class Pair {
        int startIndex = 0;
        int height = 0;

        Pair(int startIndex, int height) {
            this.startIndex = startIndex;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        int[] heights = {3,6,5,7,4,8,1,0};//{2, 1, 5, 6, 2, 3};
        LargestRectangleInHistogram obj = new LargestRectangleInHistogram();
        int result = obj.findMaxAreaInHistogram(heights);
        System.out.println("Largest Rectangle Area in the Histogram is -> " + result);
    }
}


