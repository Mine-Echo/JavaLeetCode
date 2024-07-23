
//逆波兰表达式求值
import java.util.*;

public class LeetCode150 {
    public int evalRPN(String[] tokens) {
        // 就是后缀表达式求值，直接用栈
        ArrayList<Integer> stack = new ArrayList<>();
        for (String token : tokens) {
            if (token.length() == 1
                    && (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"))) {
                int num2 = stack.remove(stack.size() - 1);
                int num1 = stack.remove(stack.size() - 1);
                switch (token.charAt(0)) {
                    case '+':
                        stack.add(num1 + num2);
                        break;
                    case '-':
                        stack.add(num1 - num2);
                        break;
                    case '*':
                        stack.add(num1 * num2);
                        break;
                    case '/':
                        stack.add(num1 / num2);
                        break;
                }
            } else {
                stack.add(Integer.parseInt(token));
            }
        }
        return stack.get(0);
    }
}
