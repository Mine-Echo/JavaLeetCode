
// 回溯法
import java.util.*;

public class LeetCode46 {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, 0, new boolean[nums.length], new Integer[nums.length]);
        return result;
    }

    private void backtrack(int[] nums, int index, boolean[] visited, Integer[] now) {
        if (index == nums.length) {
            result.add(new ArrayList<>(Arrays.asList(now)));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                now[index] = nums[i];
                backtrack(nums, index + 1, visited, now);
                visited[i] = false;
            }
        }
    }
}
