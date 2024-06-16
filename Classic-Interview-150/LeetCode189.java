//轮转数组

import java.util.Arrays;

class Solution {
    public void rotate(int[] nums, int k) {
        // int[] copy = Arrays.copyOf(nums, nums.length);
        // for (int i = 0; i < copy.length; i++) {
        //     nums[(i + k) % nums.length] = copy[i];
        // }
        // 网上看到的原地解决的方法
        // 翻转三次数组
        reverse(nums, 0, nums.length);
        reverse(nums, 0, k % nums.length);
        reverse(nums, k % nums.length, nums.length);
    }

    void reverse(int[] nums, int start, int end) {
        end--;
        while (start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            end--;
            start++;
        }
    }
}