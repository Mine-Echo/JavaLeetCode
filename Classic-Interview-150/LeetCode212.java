
// 单词搜索II
import java.util.*;

public class LeetCode212 {

    TrieNode root = new TrieNode();
    Set<String> result = new HashSet<>();

    public static void main(String[] args) {
        char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
                { 'i', 'f', 'l', 'v' } };
        String[] words = { "oath", "pea", "eat", "rain" };
        System.out.println(new LeetCode212().findWords(board, words));
    }

    public List<String> findWords(char[][] board, String[] words) {
        // 建立词典表
        for (int i = 0; i < words.length; i++) {
            addWord(words[i]);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] isVisited = new boolean[board.length][board[0].length];
                if (root.hasChild(board[i][j])) {
                    dfs(root.getChild(board[i][j]), new StringBuilder(""), i, j, board, isVisited);
                }
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(TrieNode node, StringBuilder str, int i, int j, char[][] board, boolean[][] isVisited) {
        isVisited[i][j] = true;
        str.append(board[i][j]);
        if (node.getIsWord()) {
            result.add(str.toString());
        }
        if (i > 0 && !isVisited[i - 1][j] && node.hasChild(board[i - 1][j])) {
            dfs(node.getChild(board[i - 1][j]), str, i - 1, j, board, isVisited);
        }
        if (i < board.length - 1 && !isVisited[i + 1][j] && node.hasChild(board[i + 1][j])) {
            dfs(node.getChild(board[i + 1][j]), str, i + 1, j, board, isVisited);
        }
        if (j > 0 && !isVisited[i][j - 1] && node.hasChild(board[i][j - 1])) {
            dfs(node.getChild(board[i][j - 1]), str, i, j - 1, board, isVisited);
        }
        if (j < board[0].length - 1 && !isVisited[i][j + 1] && node.hasChild(board[i][j + 1])) {
            dfs(node.getChild(board[i][j + 1]), str, i, j + 1, board, isVisited);
        }
        isVisited[i][j] = false;
        str.deleteCharAt(str.length() - 1);
    }

    private void addWord(String word) {
        TrieNode node = root;
        char[] chs = word.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (!node.hasChild(chs[i])) {
                node.addChild(chs[i], new TrieNode());
            }
            node = node.getChild(chs[i]);
        }
        node.setIsWord(true);
    }

    private class TrieNode {
        private HashMap<Character, TrieNode> children = new HashMap<>();
        private boolean isWord = false;

        public void addChild(Character ch, TrieNode node) {
            children.put(ch, node);
        }

        public boolean hasChild(Character ch) {
            return children.containsKey(ch);
        }

        public TrieNode getChild(Character ch) {
            return children.get(ch);
        }

        public boolean getIsWord() {
            return isWord;
        }

        public void setIsWord(boolean isWord) {
            this.isWord = isWord;
        }
    }
}
