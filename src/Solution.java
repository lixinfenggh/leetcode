class Solution {
    public int maxDistance(int[][] grid) {
        boolean needToScan = false;
        int[][] dis = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    dis[i][j] = 0;
                } else {
                    dis[i][j] = -1;
                }
            }
        }
        int scan = 0;
        do {
            needToScan = false;
            for (int i = 0; i < dis.length; i++) {
                for (int j = 0; j < dis[i].length; j++) {
                    if (dis[i][j] == scan) {
                        if (i-1 >= 0 && dis[i-1][j] == -1)
                            dis[i-1][j] = scan+1;
                        if (i+1 < dis.length && dis[i+1][j] == -1)
                            dis[i+1][j] = scan+1;
                        if (j-1 >= 0 && dis[i][j-1] == -1)
                            dis[i][j-1] = scan+1;
                        if (j+1 < dis[i].length && dis[i][j+1] == -1)
                            dis[i][j+1] = scan+1;
                        needToScan = true;
                    }
                }
            }
            scan++;
        } while (needToScan);

        int max = 0;
        for (int[] di : dis) {
            for (int i : di) {
                if (i > max)
                    max = i;
            }
        }
        return max == 0 ? -1 : max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxDistance(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}));
    }
}