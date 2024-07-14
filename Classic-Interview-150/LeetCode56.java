
//合并区间
import java.util.*;

public class LeetCode56 {
    public int[][] merge(int[][] intervals) {
        // 先排序，再合并
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 按照从小到大排序
                return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });
        int start = -1, end = -1;
        for (int i = 0; i < intervals.length; i++) {
            if (start == -1 && end == -1) {
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                if (intervals[i][0] <= end) {
                    end = end < intervals[i][1] ? intervals[i][1] : end;
                } else {
                    int[] bound = { start, end };
                    result.add(bound);
                    start = intervals[i][0];
                    end = intervals[i][1];
                }
            }
        }
        int[] bound = { start, end };
        result.add(bound);
        return result.toArray(new int[result.size()][]);

        // 很牛的思路，但是其实空间和时间复杂度都不低的，只是题目测试的区间最大区间才[0,10000],所以测试起来的运行时间和空间都很小
        // List<int[]> list = new ArrayList<>();
        // int max = 0, sum = 0, index = -1;
        // for (int i[] : intervals)
        // if (i[1] > max)
        // max = i[1];
        // int[] nums = new int[2 * max + 2];
        // for (int i[] : intervals) {
        // nums[2 * i[0]]++;
        // nums[2 * i[1] + 1]--;
        // }
        // for (int i = 0; i < 2 * max + 2; i++) {
        // sum += nums[i];
        // if (sum != 0 && index == -1) {
        // index = i;
        // }
        // if (sum == 0 && index != -1) {
        // list.add(new int[] { index / 2, i / 2 });
        // index = -1;
        // }
        // }
        // return list.toArray(new int[list.size()][]);
    }
}
