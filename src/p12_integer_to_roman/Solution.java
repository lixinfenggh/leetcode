package p12_integer_to_roman;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String intToRoman(int num) {
        Map<Integer, String> romanMap = new HashMap<>();
        romanMap.put(1, "I");
        romanMap.put(5, "V");
        romanMap.put(10, "X");
        romanMap.put(50, "L");
        romanMap.put(100, "C");
        romanMap.put(500, "D");
        romanMap.put(1000, "M");

        StringBuilder romanString = new StringBuilder();
        int base = 1;
        while (num > 0) {
            int bitNum = num % 10;
            if (bitNum == 4) {
                romanString.insert(0,  romanMap.get(base*5));
                romanString.insert(0, romanMap.get(base));
            } else if (bitNum == 9) {
                romanString.insert(0, romanMap.get(base * 10));
                romanString.insert(0, romanMap.get(base));
            } else if (bitNum < 4) {
                for (int i = 0; i < bitNum; i++)
                    romanString.insert(0, romanMap.get(base));
            } else {
                for (int i = 5; i < bitNum; i++)
                    romanString.insert(0, romanMap.get(base));
                romanString.insert(0, romanMap.get(base*5));
            }

            base *= 10;
            num /= 10;
        }
        return romanString.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(58));
    }
}