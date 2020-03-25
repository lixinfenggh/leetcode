public class Solution {
    public int surfaceArea(int[][] grid) {
        if (grid.length == 1 && grid[0].length == 0) return 0;
        int boxNum = 0;
        int cover = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i > 0)
                    cover += Math.min(grid[i][j], grid[i-1][j]);
                if (j > 0)
                    cover += Math.min(grid[i][j], grid[i][j-1]);
                if (grid[i][j] > 0)
                    cover += grid[i][j] - 1;
                boxNum += grid[i][j];
            }
        }

        return boxNum * 6 - cover * 2;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().surfaceArea(new int[][] {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}));
    }
}
