//Z字形变换

import java.util.Arrays;

public class LeetCode6 {
    public static String convert(String s, int numRows) {
        // 存储每一行的字符
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }
        int index = 0, last = -1, flag = 1;// flag标志正着走还是反着走
        while (index < s.length()) {
            if (last == numRows - 1)
                flag = 0;
            if (last == 0)
                flag = 1;
            if (flag == 1)
                last = (last + 1) % numRows;
            else
                last = (last - 1);
            rows[last].append(s.charAt(index));
            index++;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(convert(s, 3));
    }
}
