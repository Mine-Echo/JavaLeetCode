//成绩排序

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ68 {
    public static void main(String[] args) {
        // 用HashmMap，也可以用冒泡等稳定排序
        Scanner in = new Scanner(System.in);
        TreeMap<Integer, ArrayList<String>> map = new TreeMap<>();
        int num = in.nextInt();
        int order = in.nextInt();
        in.nextLine();
        for (int i = 0; i < num; i++) {
            String[] lines = in.nextLine().split(" ");
            int score = Integer.valueOf(lines[1]);
            if (!map.containsKey(score))
                map.put(score, new ArrayList<String>());
            map.get(score).add(lines[0]);
        }

        Set<Integer> set = order == 1 ? map.keySet() : map.descendingKeySet();
        for (Integer score : set) {
            ArrayList<String> list = map.get(score);
            for (String name : list)
                System.out.println(name + " " + score);
        }
        in.close();
    }
}