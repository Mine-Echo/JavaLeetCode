
// N 皇后 II
import java.util.*;

public class LeetCode52 {
    private int cnt = 0;

    public int totalNQueens(int n) {
        backtrack(new ArrayList<Integer>(), 0, n);
        return cnt;
    }

    private void backtrack(List<Integer> board, int now, int n) {
        if (now == n) {
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean isValid = true;
            for (int j = 0; j < now; j++) {
                int x = board.get(j);
                if (i == x || i - x == now - j || x - i == now - j) {
                    isValid = false;
                }
            }
            if (isValid) {
                board.add(i);
                backtrack(board, now + 1, n);
                board.remove(board.size() - 1);
            }
        }
    }
}
