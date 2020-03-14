package p695_max_area_of_island;

class Solution {
    private int getAreaAndChangeLand(int[][] grid, int x, int y) {
        if (grid[x][y] == 0) return 0;
        int area = 1;
        grid[x][y] = 0;
        if (x - 1 >= 0) {
            area += getAreaAndChangeLand(grid, x-1, y);
        }
        if (x + 1 < grid.length) {
            area += getAreaAndChangeLand(grid, x+1, y);
        }
        if (y - 1 >= 0) {
            area += getAreaAndChangeLand(grid, x, y-1);
        }
        if (y + 1 < grid[x].length) {
            area += getAreaAndChangeLand(grid, x, y+1);
        }
        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int area = getAreaAndChangeLand(grid, i, j);
                    if (area > maxArea)
                        maxArea = area;
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
//        int[][] a = new int[][]{
//                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
//                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
//                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
//        };
        int[][] a = new int[][] {
                {0, 1},
                {1, 1}
        };
        System.out.println(new Solution().maxAreaOfIsland(a));
    }
}