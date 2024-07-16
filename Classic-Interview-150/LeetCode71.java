
//简化路径
import java.util.*;

public class LeetCode71 {
    public String simplifyPath(String path) {
        String[] strs = Arrays.stream(path.split("[/+]")).filter(s -> !s.isEmpty()).toArray(String[]::new);
        Stack<String> stack = new Stack<>();
        for (String str : strs) {
            switch (str) {
                case ".":
                    break;
                case "..":
                    if (!stack.isEmpty())
                        stack.pop();
                    break;
                default:
                    stack.push(str);
                    break;
            }
        }
        StringBuilder result = new StringBuilder();
        if (stack.isEmpty())
            result.append("/");
        String[] arr = stack.toArray(String[]::new);
        for (int i = 0; i < arr.length; i++) {
            result.append("/");
            result.append(arr[i]);
        }
        return result.toString();
    }
}
