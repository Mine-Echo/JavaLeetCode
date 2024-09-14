
// 前缀树
import java.util.*;

public class LeetCode208 {
    class Trie {

        private class TrieNode {
            HashMap<Character, TrieNode> children = new HashMap<>();
            boolean isWord = false;
        }

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            char[] arr = word.toCharArray();
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                if (!node.children.containsKey(arr[i])) {
                    node.children.put(arr[i], new TrieNode());
                }
                node = node.children.get(arr[i]);
            }
            node.isWord = true;
        }

        public boolean search(String word) {
            char[] arr = word.toCharArray();
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                if ((node = node.children.get(arr[i])) == null) {
                    return false;
                }
            }
            return node.isWord;
        }

        public boolean startsWith(String prefix) {
            char[] arr = prefix.toCharArray();
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                if ((node = node.children.get(arr[i])) == null) {
                    return false;
                }
            }
            return true;
        }
    }
}
