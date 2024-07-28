
//在字符串中找出连续最长字符串
import java.util.ArrayList;
import java.util.Scanner;

public class HJ92 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        in.close();
        int maxLen = 0, len = 0;
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i <= chars.length; i++) {
            if (i < chars.length && chars[i] >= '0' && chars[i] <= '9') {
                len++;
                sb.append(chars[i]);
            } else {
                if (len > maxLen) {
                    maxLen = len;
                    result.clear();
                    result.add(sb.toString());
                } else if (len == maxLen && len > 0) {
                    result.add(sb.toString());
                }
                len = 0;
                if (sb.length() != 0) {
                    sb.replace(0, sb.length(), "");
                }
            }
        }
        for (String num : result) {
            System.out.print(num);
        }
        System.out.println("," + maxLen);
    }
}
