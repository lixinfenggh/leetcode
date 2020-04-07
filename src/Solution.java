class Solution {
    public void rotate(int[][] matrix) {
        int wid = matrix.length;
        for (int i = 0; i < wid/2; i++) {
            for (int j = 0; j < (wid+1)/2; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[wid-j-1][i];
                matrix[wid-j-1][i] = matrix[wid-i-1][wid-j-1];
                matrix[wid-i-1][wid-j-1] = matrix[j][wid-i-1];
                matrix[j][wid-i-1] = t;
            }
        }
    }
}