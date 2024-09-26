
// 组合总和
import java.util.ArrayList;
import java.util.List;

public class LeetCode39 {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(new ArrayList<Integer>(), 0, 0, target, candidates);
        return result;
    }

    private void backtrack(ArrayList<Integer> seq, int index, int sum, int target, int[] candidates) {
        if (sum == target) {
            result.add(new ArrayList<>(seq));
            return;
        } else if (sum > target) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            seq.add(candidates[i]);
            sum += candidates[i];
            backtrack(seq, i, sum, target, candidates);
            sum -= candidates[i];
            seq.remove(seq.size() - 1);
        }
    }
}
