// 单词搜索

public class LeetCode79 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, 0, word, board, new boolean[board.length][board[0].length])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int index, String word, char[][] board, boolean[][] visited) {
        visited[i][j] = true;
        if (word.charAt(index) == board[i][j]) {
            if (index == word.length() - 1) {
                return true;
            }
            if (i > 0 && !visited[i - 1][j] && dfs(i - 1, j, index + 1, word, board, visited)) {
                return true;
            }
            if (i < board.length - 1 && !visited[i + 1][j] && dfs(i + 1, j, index + 1, word, board, visited)) {
                return true;
            }
            if (j > 0 && !visited[i][j - 1] && dfs(i, j - 1, index + 1, word, board, visited)) {
                return true;
            }
            if (j < board[0].length - 1 && !visited[i][j + 1] && dfs(i, j + 1, index + 1, word, board, visited)) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}
