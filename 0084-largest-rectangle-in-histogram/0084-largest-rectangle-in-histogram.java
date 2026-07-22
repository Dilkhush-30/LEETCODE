class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if(n == 0) return 0;

        int maxArea = 0;
        int[] stack = new int[n + 1];
        int top = -1;

        for( int i = 0; i <= n; i++){
            int currentHeight = (i == n) ? 0 : heights[i];

            while(top >= 0 && currentHeight < heights[stack[top]]){
                int height = heights[stack[top--]];
                int width = (top == -1) ? i :i - stack[top] - 1;
                maxArea = Math.max(maxArea, height * width);           
            }
            stack[++top] = i;
        }
        return maxArea;
    }
}