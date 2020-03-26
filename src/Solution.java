public class Solution {
    public int numRookCaptures(char[][] board) {
        int x=-1, y=-1;
        mainLoop:
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                    break mainLoop;
                }
            }
        }
        int result = 0;
        for (int i = x-1; i > 0; i--) {
            if (board[i][y] == 'B') break;
            if (board[i][y] == 'p') {
                result ++;
                break;
            }
        }
        for (int i = x+1; i < board.length; i++) {
            if (board[i][y] == 'B') break;
            if (board[i][y] == 'p') {
                result ++;
                break;
            }
        }
        for (int i = y-1; i > 0; i--) {
            if (board[x][i] == 'B') break;;
            if (board[x][i] == 'p') {
                result++;
                break;
            }
        }
        for (int i = y+1; i < board[x].length; i++) {
            if (board[x][i] == 'B') break;;
            if (board[x][i] == 'p') {
                result++;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numRookCaptures(new char[][] {}));
    }
}
