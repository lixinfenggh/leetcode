import java.util.Stack;

class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        if (seq.equals("")) return new int[]{};
        if (seq.equals("()")) return new int[]{0, 0};
        int[] result = new int[seq.length()];
        Stack<Character> s1= new Stack<>(), s2 = new Stack<>();
        Stack<Character> lastIn = s1;
        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                if (lastIn == s1) {
                    s2.push('(');
                    result[i] = 1;
                    lastIn = s2;
                } else {
                    s1.push('(');
                    result[i] = 0;
                    lastIn = s1;
                }
            } else {
                if (lastIn == s1) {
                    s1.pop();
                    result[i] = 0;
                    lastIn = s2;
                } else {
                    s2.pop();
                    result[i] = 1;
                    lastIn = s1;
                }
            }
        }
        return result;
    }
}