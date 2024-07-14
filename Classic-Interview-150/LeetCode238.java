//除自身以外的数组的乘积

public class LeetCode238 {
    public int[] productExceptSelf(int[] nums) {
        // 方法1
        // int[] pre = new int[nums.length];
        // int[] post = new int[nums.length];
        // for (int i = 0; i < nums.length; i++) {
        //     if (i == 0)
        //         pre[i] = 1;
        //     else
        //         pre[i] = pre[i - 1] * nums[i - 1];
        // }
        // for (int i = nums.length - 1; i >= 0; i--) {
        //     if (i == nums.length - 1)
        //         post[i] = 1;
        //     else
        //         post[i] = post[i + 1] * nums[i + 1];
        // }
        // int[] result = new int[nums.length];
        // for (int i = 0; i < nums.length; i++) {
        //     result[i] = pre[i] * post[i];
        // }
        // return result;

        // 方法2，O1空间复杂度，用输出数组存pre，然后动态构造post
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * right;
            right *= nums[i];
        }
        return result;
    }
}