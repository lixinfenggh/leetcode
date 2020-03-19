package p15_3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length;) {
            int j = i + 1, k = nums.length-1;
            while (j < nums.length && j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    int old = nums[k];
                    do {
                        k--;
                    } while (k > i && nums[k] == old);
                    old = nums[j];
                    do {
                        j++;
                    } while (j < nums.length && nums[j] == old);
                } else if (sum > 0) {
                    int old = nums[k];
                    do {
                        k--;
                    } while (k > i && nums[k] == old);
                } else {
                    int old = nums[j];
                    do {
                        j++;
                    } while (j < nums.length && nums[j] == old);
                }
            }
            int old = nums[i];
            do {
                i++;
            } while (i < nums.length && nums[i] == old);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{-1, -1, -4}));
    }
}