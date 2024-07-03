//罗马数字转整数

public class LeetCode13 {
    public int romanToInt(String s) {
        int num = 0;
        char next;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I':
                    if (i == s.length() - 1) {
                        num += 1;
                    } else {
                        next = s.charAt(i + 1);
                        if (next == 'V') {
                            num += 4;
                            i++;
                        } else if (next == 'X') {
                            num += 9;
                            i++;
                        } else {
                            num += 1;
                        }
                    }
                    break;
                case 'V':
                    num += 5;
                    break;
                case 'X':
                    if (i == s.length() - 1) {
                        num += 10;
                    } else {
                        next = s.charAt(i + 1);
                        if (next == 'L') {
                            num += 40;
                            i++;
                        } else if (next == 'C') {
                            num += 90;
                            i++;
                        } else {
                            num += 10;
                        }
                    }
                    break;
                case 'L':
                    num += 50;
                    break;
                case 'C':
                    if (i == s.length() - 1) {
                        num += 100;
                    } else {
                        next = s.charAt(i + 1);
                        if (next == 'D') {
                            num += 400;
                            i++;
                        } else if (next == 'M') {
                            num += 900;
                            i++;
                        } else {
                            num += 100;
                        }
                    }
                    break;
                case 'D':
                    num += 500;
                    break;
                case 'M':
                    num += 1000;
                    break;
            }
        }
        return num;
    }
}