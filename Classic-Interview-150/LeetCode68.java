//文本左右对齐

import java.util.List;
import java.util.ArrayList;

public class LeetCode68 {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        int i = 0;
        while (i < words.length) {
            // 这一行的单词
            List<String> wordsInRow = new ArrayList<String>();
            int cnt = words[i].length();
            wordsInRow.add(words[i++]);
            while (i < words.length && cnt + words[i].length() + 1 <= maxWidth) {
                wordsInRow.add(words[i]);
                cnt += words[i++].length() + 1;
            }
            // 是不是最后一行
            boolean isEnd = i == words.length ? true : false;
            result.add(join(wordsInRow, maxWidth, isEnd));
        }
        return result;
    }

    // 拼接这一行
    public static String join(List<String> wordsInRow, int maxWidth, boolean isEnd) {
        StringBuilder row = new StringBuilder();
        if (isEnd) {
            // 最后一行
            for (int i = 0; i < wordsInRow.size(); i++) {
                if (i != 0)
                    row.append(' ');
                row.append(wordsInRow.get(i));
            }
            // 末尾添加空格
            while (row.length() < maxWidth) {
                row.append(' ');
            }
        } else {
            int fill = 0, remain = 0, cnt = 0;
            for (int i = 0; i < wordsInRow.size(); i++) {
                cnt += wordsInRow.get(i).length();
            }
            if (wordsInRow.size() == 1) {
                // 一行只有一个单词的特殊情况
                fill = (maxWidth - cnt);
            } else {
                fill = (maxWidth - cnt) / (wordsInRow.size() - 1);
                remain = (maxWidth - cnt) % (wordsInRow.size() - 1);
            }
            for (int i = 0; i < wordsInRow.size(); i++) {
                if (i != 0) {
                    if (i <= remain) {
                        for (int j = 0; j < fill + 1; j++)
                            row.append(' ');
                    } else {
                        for (int j = 0; j < fill; j++)
                            row.append(' ');
                    }
                }
                row.append(wordsInRow.get(i));
            }
            // 本行只有一个单词，末尾添加空格
            if (wordsInRow.size() == 1) {
                for (int j = 0; j < fill; j++)
                    row.append(' ');
            }
        }
        return row.toString();
    }

    public static void main(String[] args) {
        String[] words = { "This", "is", "an", "example", "of", "text", "justification." };
        int maxWidth = 16;
        List<String> list = fullJustify(words, maxWidth);
        System.out.println(list);
    }
}
