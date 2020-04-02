class Solution {
    public void gameOfLife(int[][] board) {
        int [][] result = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int sum = 0;
                if (i > 0) {
                    sum += board[i-1][j];
                    if (j > 0)
                        sum += board[i-1][j-1];
                    if (j+1 < board[i].length)
                        sum += board[i-1][j+1];
                }
                if (j > 0)
                    sum += board[i][j-1];
                if (j+1 < board[i].length)
                    sum += board[i][j+1];
                if (i < board.length-1) {
                    sum += board[i+1][j];
                    if (j > 0)
                        sum += board[i+1][j-1];
                    if (j+1 < board[i].length)
                        sum += board[i+1][j+1];
                }
                if (sum < 2 || sum > 3) {
                    result[i][j] = 0;
                } else if (sum == 3){
                    result[i][j] = 1;
                } else {
                    result[i][j] = board[i][j];
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++)
                board[i][j] = result[i][j];
        }
    }
}