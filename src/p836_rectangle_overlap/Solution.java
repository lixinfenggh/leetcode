package p836_rectangle_overlap;

class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0] ||
                rec1[3] <= rec2[1] ||
                rec1[0] >= rec2[2] ||
                rec1[1] >= rec2[3]);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isRectangleOverlap(
                new int[]{-7, -3, 10, 5},
                new int[]{-6, -5, 5, 10}
        ));
    }
}