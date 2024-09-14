// 添加与搜索单词-数据结构设计

import java.util.HashMap;
import java.util.Map;

public class LeetCode211 {
    private TrieNode root;

    public LeetCode211() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!node.getChildren().containsKey(chars[i])) {
                node.getChildren().put(chars[i], new TrieNode());
            }
            node = node.getChildren().get(chars[i]);
        }
        node.setIsWord(true);
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node) {
        if (word.length() == index) {
            return node.getIsWord();
        }
        char ch = word.charAt(index);
        if (ch == '.') {
            for (Map.Entry<Character, TrieNode> entry : node.getChildren().entrySet()) {
                if (dfs(word, index + 1, entry.getValue())) {
                    return true;
                }
            }
        } else if (node.getChildren().containsKey(ch)) {
            return dfs(word, index + 1, node.getChildren().get(ch));
        }

        return false;
    }

    private class TrieNode {
        private HashMap<Character, TrieNode> children = new HashMap<>();
        private boolean isWord = false;

        public HashMap<Character, TrieNode> getChildren() {
            return children;
        }

        public boolean getIsWord() {
            return isWord;
        }

        public void setIsWord(boolean isWord) {
            this.isWord = isWord;
        }
    }
}
