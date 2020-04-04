class Solution {
    public int trap(int[] height) {
        if (height.length < 3) return 0;
        int[] leftMax = new int[height.length],
                rightMax = new int[height.length];
        int max = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i-1] > max)
                max = height[i-1];
            leftMax[i] = max;
        }
        max = 0;
        for (int i = height.length-2; i >= 0; i--) {
            if (height[i+1] > max)
                max = height[i+1];
            rightMax[i] = max;
        }
        int result = 0;
        for (int i = 1; i < height.length; i++) {
            int w = Math.min(leftMax[i], rightMax[i]);
            if (height[i] < w)
                result += (w-height[i]);
        }
        return result;
    }
}