// 最小基因变化

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LeetCode433 {
    public int minMutation(String startGene, String endGene, String[] bank) {
        // BFS
        if (endGene.length() != startGene.length()) {
            return -1;
        }
        Set<String> bankSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        char[] keys = { 'A', 'C', 'G', 'T' };
        for (int i = 0; i < bank.length; i++) {
            bankSet.add(bank[i]);
        }
        if (!bankSet.contains(endGene)) {
            return -1;
        }
        Queue<String> q = new LinkedList<>();
        q.add(startGene);
        visited.add(startGene);
        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            cnt++;
            for (int k = 0; k < size; k++) {
                String now = q.remove();
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 4; j++) {
                        StringBuilder sb = new StringBuilder(now);
                        sb.setCharAt(i, keys[j]);
                        String next = sb.toString();
                        if (!visited.contains(next) && bankSet.contains(next)) {
                            if (next.equals(endGene)) {
                                return cnt;
                            }
                            visited.add(next);
                            q.add(next);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
