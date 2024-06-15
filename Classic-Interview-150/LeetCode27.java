//移除元素

class LeetCode27 {
    public int removeElement(int[] nums, int val) {
        // 自己想的一个方法，一边遍历直接完成，遍历到val时把目前最后一个元素换到该位置，然后总长度--
        int length = nums.length;
        int index = 0;
        while (index < length) {
            if (nums[index] == val) {
                if (index < length - 1) {
                    nums[index] = nums[length - 1];
                    length--;
                } else {
                    length--;
                }
            } else
                index++;
        }
        return length;

        // 网上看到一个双指针法，right用来遍历数组，left标记下一个元素需要存放的位置
        // int left = 0, right = 0;
        // for (; right < nums.length; right++) {
        //     if (nums[right] == val) {
        //         continue;
        //     }
        //     nums[left++] = nums[right];
        // }
        // return left;
    }
}