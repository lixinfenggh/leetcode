package p13_roman_to_integer;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int[] nums = new int[20];
        for (int i = 0; i < s.length(); i++) {
            nums[i] = romanMap.get(s.charAt(i));
        }

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (nums[i]<nums[i+1])
                sum -= nums[i];
            else
                sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("MCMXCIV"));
    }
}
