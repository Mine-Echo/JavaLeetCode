
// 课程表
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 拓扑排序：使用广度优先搜索
        int[] degree = new int[numCourses];
        List<Integer>[] edges = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
            degree[prerequisites[i][0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        int cnt = 0;
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int i = q.remove();
            cnt++;
            for (int j = 0; j < edges[i].size(); j++) {
                if (--degree[edges[i].get(j)] == 0) {
                    q.add(edges[i].get(j));
                }
            }
        }
        return cnt == numCourses ? true : false;
    }
}
