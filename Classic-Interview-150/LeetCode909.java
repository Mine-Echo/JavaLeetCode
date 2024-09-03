// 蛇梯棋

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode909 {
    public int snakesAndLadders(int[][] board) {
        // DFS
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int cnt = -1;
        int n = board.length;
        boolean[] isVisited = new boolean[n * n];
        isVisited[0] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            cnt++;
            for (int i = 0; i < size; i++) {
                int now = q.remove();
                if (now == n * n)
                    return cnt;
                for (int j = 1; j <= 6 && now + j <= n * n; j++) {
                    int row = getI(now + j, board), col = getJ(now + j, board);
                    if (board[row][col] != -1) {
                        if (!isVisited[board[row][col] - 1]) {
                            q.add(board[row][col]);
                            isVisited[board[row][col] - 1] = true;
                        }
                    } else {
                        if (!isVisited[now + j - 1]) {
                            q.add(now + j);
                            isVisited[now + j - 1] = true;
                        }
                    }

                }
            }
        }
        return -1;
    }

    private int getI(int index, int[][] board) {
        return board.length - 1 - (index - 1) / board[0].length;
    }

    private int getJ(int index, int[][] board) {
        return ((index - 1) / board[0].length) % 2 == 0 ? (index - 1) %
                board[0].length
                : board[0].length - 1 - (index - 1) % board[0].length;
    }

}
