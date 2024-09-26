// 括号生成
import java.util.ArrayList;
import java.util.List;

public class LeetCode22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrace(n, n, new StringBuilder(), result);
        return result;
    }

    private void backtrace(int l, int r, StringBuilder sb, List<String> list) {
        if (l == 0 && r == 0) {
            list.add(sb.toString());
            return;
        }
        if (l > 0) {
            sb.append('(');
            backtrace(l - 1, r, sb, list);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (l < r) {
            sb.append(')');
            backtrace(l, r - 1, sb, list);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
