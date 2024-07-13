//生命游戏

public class LeetCode289 {
    public void gameOfLife(int[][] board) {
        // 新建一个数组模拟
        // int[][] nextStatus = new int[board.length][board[0].length];
        // for (int i = 0; i < board.length; i++) {
        //     for (int j = 0; j < board[i].length; j++) {
        //         int cnt = 0;
        //         if (i > 0 && j > 0 && board[i - 1][j - 1] == 1)
        //             cnt++;
        //         if (i > 0 && board[i - 1][j] == 1)
        //             cnt++;
        //         if (i > 0 && j < board[0].length - 1 && board[i - 1][j + 1] == 1)
        //             cnt++;
        //         if (j > 0 && board[i][j - 1] == 1)
        //             cnt++;
        //         if (j < board[0].length - 1 && board[i][j + 1] == 1)
        //             cnt++;
        //         if (i < board.length - 1 && j > 0 && board[i + 1][j - 1] == 1)
        //             cnt++;
        //         if (i < board.length - 1 && board[i + 1][j] == 1)
        //             cnt++;
        //         if (i < board.length - 1 && j < board[0].length - 1 && board[i + 1][j + 1] == 1)
        //             cnt++;
        //         if (cnt < 2) {
        //             nextStatus[i][j] = 0;
        //         }
        //         if (cnt == 2) {
        //             if (board[i][j] == 1)
        //                 nextStatus[i][j] = 1;
        //             else
        //                 nextStatus[i][j] = 0;
        //         }
        //         if (cnt == 3) {
        //             nextStatus[i][j] = 1;
        //         }
        //         if (cnt > 3) {
        //             nextStatus[i][j] = 0;
        //         }
        //     }
        // }
        // for (int i = 0; i < board.length; i++) {
        //     for (int j = 0; j < board[0].length; j++) {
        //         board[i][j] = nextStatus[i][j];
        //     }
        // }

        // 原地算法，注意到这题的数据范围是0和1，可以用其他数字来标记转换状态
        // 0->1用2标记，1->0用-1标记
        // 写代码的时候注意到一点，&&的优先级大于||，我之前记反了
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int cnt = 0;
                if (i > 0 && j > 0 && (board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == -1))
                    cnt++;
                if (i > 0 && (board[i - 1][j] == 1 || board[i - 1][j] == -1))
                    cnt++;
                if (i > 0 && j < board[0].length - 1 && (board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == -1))
                    cnt++;
                if (j > 0 && (board[i][j - 1] == 1 || board[i][j - 1] == -1))
                    cnt++;
                if (j < board[0].length - 1 && (board[i][j + 1] == 1 || board[i][j + 1] == -1))
                    cnt++;
                if (i < board.length - 1 && j > 0 && (board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == -1))
                    cnt++;
                if (i < board.length - 1 && (board[i + 1][j] == 1 || board[i + 1][j] == -1))
                    cnt++;
                if (i < board.length - 1 && j < board[0].length - 1 && (board[i + 1][j + 1] == 1
                        || board[i + 1][j + 1] == -1))
                    cnt++;
                if (cnt < 2) {
                    board[i][j] = board[i][j] == 1 ? -1 : 0;
                }
                if (cnt == 2) {
                    board[i][j] = board[i][j] == 1 ? 1 : 0;
                }
                if (cnt == 3) {
                    board[i][j] = board[i][j] == 1 ? 1 : 2;
                }
                if (cnt > 3) {
                    board[i][j] = board[i][j] == 1 ? -1 : 0;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == -1) {
                    board[i][j] = 0;
                }
            }
        }
    }
}
