
public class LeetCode130 {

    public void solve(char[][] board) {
        char[][] copy = new char[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                copy[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (copy[i][j] == 'O') {
                    if (check(i, j, copy)) {
                        modify(i, j, board);
                    }
                }
            }
        }
    }

    void modify(int i, int j, char[][] board) {
        board[i][j] = 'X';
        if (i > 0 && board[i - 1][j] == 'O') {
            modify(i - 1, j, board);
        }
        if (i < board.length - 1 && board[i + 1][j] == 'O') {
            modify(i + 1, j, board);
        }
        if (j > 0 && board[i][j - 1] == 'O') {
            modify(i, j - 1, board);
        }
        if (j < board[0].length - 1 && board[i][j + 1] == 'O') {
            modify(i, j + 1, board);
        }
    }

    boolean check(int i, int j, char[][] board) {
        board[i][j] = 'M';
        boolean ret = true;
        if (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) {
            ret = false;
        }
        if (i > 0 && board[i - 1][j] == 'O') {
            ret = check(i - 1, j, board) && ret;
        }
        if (i < board.length - 1 && board[i + 1][j] == 'O') {
            ret = check(i + 1, j, board) && ret;
        }
        if (j > 0 && board[i][j - 1] == 'O') {
            ret = check(i, j - 1, board) && ret;
        }
        if (j < board[0].length - 1 && board[i][j + 1] == 'O') {
            ret = check(i, j + 1, board) && ret;
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode130 l = new LeetCode130();
        char[][] board = { { 'O', 'O', 'O', 'O', 'X', 'X' }, { 'O', 'O', 'O', 'O', 'O', 'O' },
                { 'O', 'X', 'O', 'X', 'O', 'O' }, { 'O', 'X', 'O', 'O', 'X', 'O' }, { 'O', 'X', 'O', 'X', 'O', 'O' },
                { 'O', 'X', 'O', 'O', 'O', 'O' } };
        l.solve(board);
    }
}