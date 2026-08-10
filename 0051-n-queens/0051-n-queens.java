import java.util.*;

class Solution {

    public void solve(int col, char[][] board, List<List<String>> ans, int n) {

        if (col == n) {
            List<String> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                list.add(new String(board[i]));
            }

            ans.add(list);
            return;
        }

        for (int row = 0; row < n; row++) {

            if (isSafe(row, col, board, n)) {

                board[row][col] = 'Q';

                solve(col + 1, board, ans, n);

                board[row][col] = '.';
            }
        }
    }

    public boolean isSafe(int row, int col, char[][] board, int n) {

        // Check same row on left side
        for (int j = 0; j < col; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal
        int i = row - 1;
        int j = col - 1;

        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }

            i--;
            j--;
        }

        // Check lower-left diagonal
        i = row + 1;
        j = col - 1;

        while (i < n && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        solve(0, board, ans, n);

        return ans;
    }
}