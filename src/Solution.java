import java.util.ArrayList;
import java.util.List;

class Solution {
    private String reverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }

    public int minimumLengthEncoding(String[] words) {
        List<String> result = new ArrayList<String>();
        result.add(reverse(words[0]));
        for (int i = 1; i < words.length; i++) {
            boolean in = false;
            String rw = reverse(words[i]);
            for (int j = 0; j < result.size(); j++) {
                if (result.get(j).length() > rw.length()) {
                    if (result.get(j).substring(0, rw.length()).equals(rw)) {
                        in = true;
                        break;
                    }
                } else if (rw.substring(0, result.get(j).length()).equals(result.get(j))) {
                    in = true;
                    result.set(j, rw);
                    break;
                }
            }
            if (!in)
                result.add(rw);
        }
        int sum = 0;
        for (int i = 0; i < result.size(); i++) {
            sum += result.get(i).length();
        }
        sum += result.size();
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumLengthEncoding(new String[]{"time", "me", "bell"}));
    }
}