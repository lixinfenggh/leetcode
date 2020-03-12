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
        while (p1 < nums.length-3) {
            int num1 = nums[p1];
            while (p2 < nums.length-2) {
                int num2 = nums[p2];
                while (p3 < p4) {
                    int sum = nums[p1] + nums[p2] + nums[p3] + nums[p4];
                    int num3 = nums[p3];
                    int num4 = nums[p4];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[p1], nums[p2], nums[p3], nums[p4]));
                        while (++p3 < p4 && nums[p3] == num3){}
                        while (--p4 > p3 && nums[p4] == num4){}
                    } else if (sum < target) {
                        while (++p3 < p4 && nums[p3] == num3){}
                    } else {
                        while (--p4 > p3 && nums[p4] == num4){}
                    }
                }
                while (++p2 < nums.length && num2 == nums[p2]){}
                p3 = p2 + 1;
                p4 = nums.length - 1;
            }

            while (++p1 < nums.length && num1 == nums[p1]){}
            p2 = p1 + 1;
            p3 = p2 + 1;
            p4 = nums.length - 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fourSum(new int[]{-2, -1, -1, 0, 0, 1, 2}, 0).toString());
    }
}