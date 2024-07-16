
//用最少数量的箭引爆气球
import java.util.*;

public class LeetCode452 {
    public int findMinArrowShots(int[][] points) {
        // 先排序，然后遍历计数
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]) == 0 ? Integer.compare(o1[1], o2[1])
                        : Integer.compare(o1[0], o2[0]);
            }
        });
        int cnt = 0, left = 0, right = 0;
        for (int i = 0; i < points.length; i++) {
            if (i == 0 || points[i][0] > right || points[i][1] < left) {
                cnt++;
                left = points[i][0];
                right = points[i][1];
            } else {
                left = Math.max(left, points[i][0]);
                right = Math.min(right, points[i][1]);
            }
        }
        return cnt;
    }
}
