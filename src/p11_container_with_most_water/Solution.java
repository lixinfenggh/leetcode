package p11_container_with_most_water;

class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 1; i < height.length; i++) {
            int _maxArea = 0;
            for (int j = 0; j < i; j++) {
                int area = (i-j) * Math.min(height[i], height[j]);
                if (area > _maxArea)
                    _maxArea = area;
            }
            if (_maxArea > maxArea)
                maxArea = _maxArea;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}