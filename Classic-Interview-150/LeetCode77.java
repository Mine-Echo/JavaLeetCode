
// 组合
import java.util.*;

public class LeetCode77 {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        Integer[] array = new Integer[k];
        for (int i = 0; i < n; i++) {
            dfs(i + 1, 0, n, k, array);
        }
        return result;
    }

    private void dfs(int now, int index, int n, int k, Integer[] array) {
        array[index] = now;
        if (index == k - 1) {
            result.add(new ArrayList<>(Arrays.asList(array)));
            return;
        }
        for (int i = now + 1; i <= n; i++) {
            dfs(i, index + 1, n, k, array);
        }
    }

    public static void main(String[] args) {
        new LeetCode77().combine(4, 2);
    }
}
