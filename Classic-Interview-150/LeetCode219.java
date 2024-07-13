
//存在重复元素
import java.util.*;

public class LeetCode219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 滑动窗口+set
        if (k == 0)
            return false;
        int left = 0, right = 0;
        Set<Integer> set = new HashSet<>();
        while (right < nums.length) {
            if (set.contains(nums[right]))
                return true;
            else
                set.add(nums[right]);
            right++;
            if (right - left > k) {
                set.remove(nums[left++]);
            }
        }
        return false;

        // 另一种方法：hashtable记录索引
    }
}