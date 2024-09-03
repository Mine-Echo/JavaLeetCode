// 课程表II
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode210 {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int course = q.remove();
            result[cnt++] = course;
            for (int i = 0; i < edges[course].size(); i++) {
                if (--degree[edges[course].get(i)] == 0) {
                    q.add(edges[course].get(i));
                }
            }
        }
        if (cnt == numCourses) {
            return result;
        }
        return new int[0];
    }
}
