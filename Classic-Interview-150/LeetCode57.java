//插入区间

import java.util.ArrayList;

public class LeetCode57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 自己写的寻找合并区间的方法，情况非常复杂，修补了好久才过
        ArrayList<int[]> result = new ArrayList<>();
        // left为需要合并的最左区间，right为需要合并的最右区间
        int left = -1, right = -1;// 如果不能合并区间，left和right都为-1
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[1] >= intervals[i][0] && newInterval[0] <= intervals[i][1]) {
                // 找到最左合并区间
                left = i;
                break;
            } else if (newInterval[1] < intervals[i][0] || i == intervals.length - 1) {
                // 没有合并区间的情况
                break;
            }
        }
        if (left != -1) {
            // 找right
            for (int i = left; i < intervals.length; i++) {
                if (newInterval[1] < intervals[i][0]) {
                    // 最右合并区间为前一个
                    right = i - 1;
                    break;
                } else if (newInterval[1] <= intervals[i][1] || i == intervals.length - 1) {
                    // 最右合并区间为当前区间
                    right = i;
                    break;
                }
            }
            for (int i = 0; i < left; i++) {
                result.add(intervals[i]);
            }
            // 添加合并区间
            result.add(new int[] { Math.min(intervals[left][0], newInterval[0]),
                    Math.max(intervals[right][1], newInterval[1]) });
            for (int i = right + 1; i < intervals.length; i++) {
                result.add(intervals[i]);
            }
        } else {
            // 没有需要合并的区间的情况
            int index = 0;
            while (index < intervals.length && intervals[index][1] < newInterval[0]) {
                result.add(intervals[index++]);
            }
            result.add(newInterval);
            while (index < intervals.length) {
                result.add(intervals[index++]);
            }
        }
        return result.toArray(new int[0][0]);

        // 解答上的方法，用left和right标记合并区间[left, right]，写起来就简单多了
        // ArrayList<int[]> result = new ArrayList<>();
        // int left = newInterval[0], right = newInterval[1];
        // boolean isDone = false;
        // for (int i = 0; i < intervals.length; i++) {
        //     if (intervals[i][0] > right) {
        //         if (!isDone) {
        //             isDone = true;
        //             result.add(new int[] { left, right });
        //         }
        //         result.add(intervals[i]);
        //     } else if (intervals[i][1] < left) {
        //         result.add(intervals[i]);
        //     } else {
        //         // 需要合并
        //         left = Math.min(left, intervals[i][0]);
        //         right = Math.max(right, intervals[i][1]);
        //     }
        // }
        // if (!isDone) {
        //     result.add(new int[] { left, right });
        // }
        // return result.toArray(new int[0][0]);

        // 也可以用LeetCode56差不多的方法，先插进来，排序，再合并
    }
}
