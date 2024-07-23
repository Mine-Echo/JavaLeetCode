//基本计算器

import java.util.*;

public class LeetCode224 {
    private Deque<String> postfix = new LinkedList<>();
    private Deque<Integer> numStack = new LinkedList<>();
    private Deque<Character> opStack = new LinkedList<>();
    private Map<Character, Integer> priority = new HashMap<Character, Integer>();

    public LeetCode224() {
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);
        priority.put('(', 0);// 放进栈之间优先级无限大，放进去之后优先级无限小
    }

    public int calculate(String s) {
        // 先把中缀表达式转为后缀表达式，再计算后缀表达式的值，单目运算符-x处理成0-x
        s = s.replaceAll(" ", "");
        int sign = 1;
        char[] chars = s.toCharArray();
        int i = 0;
        // 中缀转后缀
        while (i < chars.length) {
            char ch = chars[i];
            if (Character.isDigit(ch)) {
                // 数字
                int num = 0;
                while (i < chars.length && Character.isDigit(chars[i])) {
                    num = num * 10 + chars[i] - 48;
                    i++;
                }
                postfix.push(String.valueOf(sign * num));
            } else {
                // 单目运算符-的情况
                if (i == 0 && ch == '-' || i > 0 && chars[i - 1] == '(' && ch == '-') {
                    postfix.push("0");
                }
                if (ch == ')') {
                    while (!opStack.peek().equals('(')) {
                        postfix.push(String.valueOf(opStack.pop()));
                    }
                    opStack.pop();
                } else {
                    while (!opStack.isEmpty() && (ch != '(' && priority.get(opStack.peek()) >= priority.get(ch))) {
                        postfix.push(String.valueOf(opStack.pop()));
                    }
                    opStack.push(ch);
                }
                i++;
            }
        }
        while (!opStack.isEmpty()) {
            postfix.push(String.valueOf(opStack.pop()));
        }
        // 计算后缀表达式
        while (!postfix.isEmpty()) {
            String str = postfix.pollLast();
            if (str.equals("-")) {
                int num2 = numStack.pop();
                int num1 = numStack.pop();
                numStack.push(num1 - num2);
            } else if (str.equals("+")) {
                int num2 = numStack.pop();
                int num1 = numStack.pop();
                numStack.push(num1 + num2);
            } else if (str.equals("*")) {
                int num2 = numStack.pop();
                int num1 = numStack.pop();
                numStack.push(num1 * num2);
            } else if (str.equals("/")) {
                int num2 = numStack.pop();
                int num1 = numStack.pop();
                numStack.push(num1 / num2);
            } else {
                numStack.push(Integer.parseInt(str));
            }
        }
        return numStack.pop();
    }
}

// 官方解法，因为这题没有乘除法，核心思想就是直接把括号去除，然后就是顺序运算
// 官方解法就是每次遇到（ 就把当前符号压栈，遇到 ）就出栈，实际的符号就是 遇到的符号*栈顶的符号
// 相当于在遍历的同时把左右括号去掉了，然后如果括号外面为-号，就把括号内的+变成-，-变成+
class Solution {
    public int calculate(String s) {
        Deque<Integer> ops = new LinkedList<Integer>();
        ops.push(1);
        int sign = 1;

        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }
}
