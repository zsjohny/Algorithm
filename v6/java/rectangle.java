public class Solution {
    public int largestRectangleArea(int[] height) {
        height = Arrays.copyOf(height, height.length + 1);

        int maxRect = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < height.length; ++i) {
            while (!stack.isEmpty() && height[i] < height[stack.peek()]) {
                int rect = height[stack.pop()] * (stack.isEmpty() ? i : (i-stack.peek()-1));
                maxRect = Math.max(maxRect, rect);
            }
            stack.push(i);
        }

        return maxRect;
    }
}

