package p300_longest_increasing_subsequence;

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 1) return nums.length;
        int[] lengthLis = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && lengthLis[j]+1 > max) {
                    max = lengthLis[j] + 1;
                }
            }
            lengthLis[i] = max;
        }
        int max = 0;
        for (int lengthLi : lengthLis) {
            if (max < lengthLi)
                max = lengthLi;
        }
        return max+1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLIS(new int[]{}));
    }
}
