
//24点运算
import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ89 {

    private static String[][] all = new String[4 * 3 * 2][4];
    private static int conditions = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        in.close();
        String[] pokes = input.split(" ");
        for (int i = 0; i < pokes.length; i++) {
            if (pokes[i].length() != 1) {
                System.out.println("ERROR");
                return;
            }
        }
        // 穷举
        permute(pokes, 0);

        for (int i = 0; i < conditions; i++) {
            StringBuilder sb = new StringBuilder();
            if (dfs(all[i], 0, sb)) {
                System.out.println(sb.toString());
                return;
            }
        }
        System.out.println("NONE");
    }

    private static void permute(String[] arr, int currentIndex) {
        if (currentIndex == arr.length - 1) {
            // System.out.println(Arrays.toString(arr));
            all[conditions++] = Arrays.copyOf(arr, arr.length);
        } else {
            for (int i = currentIndex; i < arr.length; i++) {
                swap(arr, currentIndex, i);
                permute(arr, currentIndex + 1);
                swap(arr, currentIndex, i); // Backtrack
            }
        }
    }

    private static void swap(String[] arr, int index1, int index2) {
        String temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private static boolean dfs(String[] pokes, int i, StringBuilder result) {
        result.append(pokes[i]);
        if (i != 3) {
            if (dfs(pokes, i + 1, result.append("+"))) {
                return true;
            }
            result.deleteCharAt(result.length() - 1);
            if (dfs(pokes, i + 1, result.append("-"))) {
                return true;
            }
            result.deleteCharAt(result.length() - 1);
            if (dfs(pokes, i + 1, result.append("*"))) {
                return true;
            }
            result.deleteCharAt(result.length() - 1);
            if (dfs(pokes, i + 1, result.append("/"))) {
                return true;
            }
            result.delete(result.length() - 2, result.length());
        } else {
            // 计算结果是否为24
            if (accumulate(result) == 24) {
                return true;
            } else {
                result.deleteCharAt(result.length() - 1);
            }
        }
        return false;
    }

    private static int accumulate(StringBuilder formula) {
        // 先把中缀计算式转换为后缀表达式
        char[] signStack = new char[3];
        int signPointer = 0;
        StringBuilder postfix = new StringBuilder();
        for (int i = 0; i < formula.length(); i++) {
            char ch = formula.charAt(i);
            if (ch <= 57 && ch >= 48 || ch == 'A' || ch == 'J' || ch == 'Q' || ch == 'K') {
                postfix.append(ch);
            } else {
                if (signPointer == 0) {
                    signStack[signPointer++] = ch;
                } else {
                    while (signPointer != 0) {
                        postfix.append(signStack[--signPointer]);
                    }
                    signStack[signPointer++] = ch;
                }
            }
        }
        while (signPointer != 0) {
            postfix.append(signStack[--signPointer]);
        }
        // 再用栈计算后缀表达式的值
        int[] stack = new int[4];
        int pointer = 0;
        for (int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);
            if (ch <= 57 && ch >= 48) {
                stack[pointer++] = ch - 48;
            } else if (ch == 'A') {
                stack[pointer++] = 1;
            } else if (ch == 'J') {
                stack[pointer++] = 11;
            } else if (ch == 'Q') {
                stack[pointer++] = 12;
            } else if (ch == 'K') {
                stack[pointer++] = 13;
            } else {
                int num2 = stack[--pointer];
                int num1 = stack[--pointer];
                switch (ch) {
                    case '+':
                        stack[pointer++] = num1 + num2;
                        break;
                    case '-':
                        stack[pointer++] = num1 - num2;
                        break;
                    case '*':
                        stack[pointer++] = num1 * num2;
                        break;
                    case '/':
                        stack[pointer++] = num1 / num2;
                        break;
                }
            }
        }
        return stack[0];
    }

}