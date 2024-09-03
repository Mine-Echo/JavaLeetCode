// 除法求值

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LeetCode399 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // BFS的解法
        int nvars = 0;
        Map<String, Integer> variables = new HashMap<String, Integer>();

        int n = equations.size();
        for (int i = 0; i < n; i++) {
            if (!variables.containsKey(equations.get(i).get(0))) {
                variables.put(equations.get(i).get(0), nvars++);
            }
            if (!variables.containsKey(equations.get(i).get(1))) {
                variables.put(equations.get(i).get(1), nvars++);
            }
        }

        // 对于每个点，存储其直接连接到的所有点及对应的权值
        List<Pair>[] edges = new List[nvars];
        for (int i = 0; i < nvars; i++) {
            edges[i] = new ArrayList<Pair>();
        }
        for (int i = 0; i < n; i++) {
            int va = variables.get(equations.get(i).get(0)), vb = variables.get(equations.get(i).get(1));
            edges[va].add(new Pair(vb, values[i]));
            edges[vb].add(new Pair(va, 1.0 / values[i]));
        }

        int size = queries.size();
        double[] result = new double[size];
        Arrays.fill(result, -1.0);
        for (int i = 0; i < size; i++) {
            int src = variables.containsKey(queries.get(i).get(0)) ? variables.get(queries.get(i).get(0))
                    : -1;
            int dst = variables.containsKey(queries.get(i).get(1)) ? variables.get(queries.get(i).get(1))
                    : -1;
            if (src == -1 || dst == -1) {
                continue;
            }
            // bfs
            boolean[] visited = new boolean[nvars];
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(src, 1.0));
            while (!q.isEmpty()) {
                Pair pair = q.remove();
                int index = pair.index;
                visited[index] = true;
                if (index == dst) {
                    result[i] = pair.value;
                    break;
                }
                for (int j = 0; j < edges[index].size(); j++) {
                    if (!visited[(int) edges[index].get(j).index]) {
                        q.add(new Pair(edges[index].get(j).index,
                                (double) edges[index].get(j).value * (double) pair.value));
                    }
                }
            }
        }
        return result;
    }

    class Pair {
        int index;
        double value;

        Pair(int index, double value) {
            this.index = index;
            this.value = value;
        }
    }
}