//字母异位词分组

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 记录每个字符出现的次数来当key
        // Map<String, List<String>> map = new HashMap<>();
        // for (int i = 0; i < strs.length; i++) {
        //     String str = strs[i];
        //     char[] chs = str.toCharArray();
        //     int[] count = new int[26];
        //     for (int j = 0; j < chs.length; j++) {
        //         count[chs[j] - 97] += 1;
        //     }
        //     StringBuilder sb = new StringBuilder();
        //     for (int j = 0; j < count.length; j++) {
        //         sb.append((char) (97 + j));
        //         sb.append(count[j]);
        //     }
        //     String key = sb.toString();
        //     if (!map.containsKey(key))
        //         map.put(key, new ArrayList<>());
        //     map.get(key).add(str);
        // }
        // return map.values().stream().collect(Collectors.toList());

        //将字符排序作为key
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
