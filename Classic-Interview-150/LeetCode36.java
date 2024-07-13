//有效的数独

public class LeetCode36 {
    public boolean isValidSudoku(char[][] board) {
        // 判断行
        for (int i = 0; i < 9; i++) {
            int[] isExit = new int[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (isExit[board[i][j] - 49] == 0)
                        isExit[board[i][j] - 49] = 1;
                    else {
                        return false;
                    }
                }
            }
        }
        // 判断列
        for (int i = 0; i < 9; i++) {
            int[] isExit = new int[9];
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (isExit[board[j][i] - 49] == 0)
                        isExit[board[j][i] - 49] = 1;
                    else {
                        return false;
                    }
                }
            }
        }
        // 每个小格子
        int[][] isExit = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.')
                    if (isExit[i / 3 * 3 + j / 3][board[i][j] - 49] == 0) {
                        isExit[i / 3 * 3 + j / 3][board[i][j] - 49] = 1;
                    } else {
                        return false;
                    }
            }
        }
        return true;
    }
}
