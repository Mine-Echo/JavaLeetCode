// 岛屿数量

import java.util.*;

public class LeetCode200 {

    int[] parent;

    private int find(int x) {
        if (parent[x] == -1) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private void union(int x, int y) {
        if (find(x) != find(y)) {
            parent[find(y)] = find(x);
        }
    }

    public int numIslands(char[][] grid) {
        // 并查集解法
        parent = new int[grid.length * grid[0].length];
        Arrays.fill(parent, -1);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int x = i * grid[0].length + j;
                if (grid[i][j] == '1') {
                    grid[i][j] = '2';
                    if (i > 0 && grid[i - 1][j] == '1')
                        union(x, (i - 1) * grid[0].length + j);
                    if (i < grid.length - 1 && grid[i + 1][j] == '1')
                        union(x, (i + 1) * grid[0].length + j);
                    if (j > 0 && grid[i][j - 1] == '1')
                        union(x, i * grid[0].length + j - 1);
                    if (j < grid[0].length - 1 && grid[i][j + 1] == '1')
                        union(x, i * grid[0].length + j + 1);
                } else {
                    parent[x] = -2;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1) {
                count++;
            }
        }
        return count;
    }



    // BFS
    // public int numIslands(char[][] grid) {
    //     int rowLen = grid[0].length;
    //     int colLen = grid.length;
    //     int count = 0;
    //     Queue<Integer> q = new LinkedList<>();
    //     for (int i = 0; i < colLen; i++) {
    //         for (int j = 0; j < rowLen; j++) {
    //             if (grid[i][j] == '1') {
    //                 count++;
    //                 q.add(i * rowLen + j);
    //                 grid[i][j] = '2';
    //                 while (!q.isEmpty()) {
    //                     int n = q.remove();
    //                     int col = n / rowLen;
    //                     int row = n % rowLen;
    //                     if (row > 0 && grid[col][row - 1] == '1') {
    //                         q.add(col * rowLen + row - 1);
    //                         grid[col][row - 1] = '2';
    //                     }
    //                     if (row < rowLen - 1 && grid[col][row + 1] == '1') {
    //                         q.add(col * rowLen + row + 1);
    //                         grid[col][row + 1] = '2';
    //                     }
    //                     if (col > 0 && grid[col - 1][row] == '1') {
    //                         q.add((col - 1) * rowLen + row);
    //                         grid[col - 1][row] = '2';
    //                     }
    //                     if (col < colLen - 1 && grid[col + 1][row] == '1') {
    //                         q.add((col + 1) * rowLen + row);
    //                         grid[col + 1][row] = '2';
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     return count;
    // }
}
