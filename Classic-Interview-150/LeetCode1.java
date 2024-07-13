
//两数之和
import java.util.*;

public class LeetCode1 {
    public int[] twoSum(int[] nums, int target) {
        // 先排序然后用双指针，最后找到原数组的位置，细节方面比较繁琐，时间复杂度Onlogn
        // int[] copy = Arrays.copyOf(nums, nums.length);
        // Arrays.sort(copy);
        // int left = 0, right = nums.length - 1;
        // while (left < right) {
        //     if (copy[left] + copy[right] > target)
        //         right--;
        //     else if (copy[left] + copy[right] < target)
        //         left++;
        //     else
        //         break;
        // }
        // int[] ret = new int[2];
        // for (int i = 0; i < nums.length; i++) {
        //     if (left != -1 && nums[i] == copy[left]) {
        //         ret[0] = i;
        //         left = -1;
        //     } else if (right != -1 && nums[i] == copy[right]) {
        //         ret[1] = i;
        //         right = -1;
        //     }
        //     if (left == -1 && right == -1)
        //         break;
        // }
        // Arrays.sort(ret);
        // return ret;

        // 用哈希表，<target-num[index],index> ，时间复杂度On
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[] { map.get(nums[i]), i };
            } else {
                map.put(target - nums[i], i);
            }
        }
        return null;
    }
}
