
public class JZ53 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param nums int整型一维数组
     * @param k    int整型
     * @return int整型
     */
    public int GetNumberOfK(int[] nums, int k) {
        // write code here
        // 暴力遍历法
        // int cnt = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] == k)
        //         cnt++;
        // }
        // return cnt;

        // 二分法
        int left = 0, right = nums.length - 1;
        int cnt = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < k) {
                left = mid + 1;
            } else if (nums[mid] > k) {
                right = mid - 1;
            } else {
                // 找出有几个
                int i = mid;
                while (i < nums.length && nums[i] == k) {
                    cnt++;
                    i++;
                }
                i = mid - 1;
                while (i >= 0 && nums[i] == k) {
                    cnt++;
                    i--;
                }
                break;
            }
        }
        return cnt;
    }
}