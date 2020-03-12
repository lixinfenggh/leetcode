package p18_4sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList <>();
        if (nums.length < 4) return new ArrayList<>();
        int p1 = 0, p2 = 1, p3 = 2, p4 = nums.length-1;
        while (p1 < nums.length) {
            while (p2 < nums.length) {
                while (p3 < p4) {
                    int sum = nums[p1] + nums[p2] + nums[p3] + nums[p4];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[p1], nums[p2], nums[p3], nums[p4]));
                        p3 = p3 + 1;
                        p4 = p4 - 1;
                    } else if (sum < target) {
                        p3 = p3 + 1;
                    } else {
                        p4 = p4 - 1;
                    }
                }
                p2 ++;
                p3 = p2 + 1;
                p4 = nums.length - 1;
            }
            p1 ++;
            p2 = p1 + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fourSum(new int[]{-2, -1, 0, 0, 1, 2}, 0).toString());
    }
}