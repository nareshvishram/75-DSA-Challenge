class Solution {
    public void solveSudoku(char[][] board) {
        solveable(board);
    }

    private boolean solveable(char[][] board) {
        boolean empty = false;
        int i = 0, j = 0;
        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    empty = true;
                    break;
                }
            }
            if (empty)
                break;
        }
        if (!empty)
            return true;
        for (int num = 1; num <= 9; num++) {
            if (isValid(i, j, num, board)) {
                board[i][j] = (char) (num + '0');
                if (solveable(board))
                    return true;
                board[i][j] = '.';
            }
        }
        return false;
    }

    private boolean isValid(int r, int c, int num, char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (board[i][c] == (char) (num + '0') || board[r][i] == (char) (num + '0'))
                return false;
        }
        int rowStart = r - r % 3;
        int colStart = c - c % 3;
        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (board[i][j] == (char) (num + '0'))
                    return false;
            }
        }
        return true;
    }
}