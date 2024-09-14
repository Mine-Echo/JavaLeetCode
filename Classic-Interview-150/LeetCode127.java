// 单词接龙

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LeetCode127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // BFS
        if (beginWord.length() != endWord.length() || beginWord.equals(endWord)) {
            return 0;
        }
        Set<String> words = new HashSet<>();
        char[] chars = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
                't', 'u', 'v', 'w', 'x', 'y', 'z' };
        for (String word : wordList) {
            words.add(word);
        }
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.add(beginWord);
        visited.add(beginWord);
        int cnt = 1;
        while (!q.isEmpty()) {
            cnt++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String word = q.remove();
                for (int j = 0; j < word.length(); j++) {
                    for (int k = 0; k < 26; k++) {
                        StringBuilder sb = new StringBuilder(word);
                        sb.setCharAt(j, chars[k]);
                        String newWord = sb.toString();
                        if (words.contains(newWord) && !visited.contains(newWord)) {
                            if (newWord.equals(endWord)) {
                                return cnt;
                            }
                            q.add(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
