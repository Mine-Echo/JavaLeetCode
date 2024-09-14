
//电话号码的字母组合
import java.util.*;

public class LeetCode17 {
    private List<String> result = new ArrayList<>();
    private char[][] table = { { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
            { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

    public List<String> letterCombinations(String digits) {
        dfs(digits, 0, new StringBuilder(""));
        return result;
    }

    private void dfs(String digits, int index, StringBuilder letters) {
        if (digits.length() == index) {
            if (index != 0) {
                result.add(letters.toString());
            }
            return;
        }
        int i = digits.charAt(index) - 50;
        for (int j = 0; j < table[i].length; j++) {
            letters.append(table[i][j]);
            dfs(digits, index + 1, letters);
            letters.deleteCharAt(index);
        }
    }
}
