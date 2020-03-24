public class Solution {
    public int massage(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int maxLength1 = nums[0], maxLength2 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int old1 = maxLength1;
            maxLength1 = maxLength2;
            maxLength2 = Math.max(old1+nums[i], maxLength2);
        }
        return Math.max(maxLength1, maxLength2);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().massage(new int[] {1, 3, 1, 3, 100}));
    }
}
