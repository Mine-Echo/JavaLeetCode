//删除有序数组的重复项
class Solution {
    public int removeDuplicates(int[] nums) {
        // 感觉可以用双指针法
        if (nums.length == 0)
            return 0;
        int left = 1, right = 1;
        for (; right < nums.length; right++) {
            if (nums[left - 1] != nums[right]) {
                // 存放不重复的元素
                nums[left++] = nums[right];
            }
        }
        return left;
    }
}