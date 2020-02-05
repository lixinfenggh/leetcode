package p9_palindrome_number;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)  return false;
        try {
            int oldX = x;
            int newNum = 0;
            while (x > 0) {
                newNum = newNum * 10 + x % 10;
                x = x / 10;
            }
            return newNum == oldX;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(10));
    }
}