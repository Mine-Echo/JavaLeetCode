//跳跃游戏
public class LeetCode55 {
    public boolean canJump(int[] nums) {
        // 从后往前判断很容易
        if (nums.length < 2)
            return true;
        int position = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= position - i)
                position = i;
        }
        if (position == 0)
            return true;
        else
            return false;

        // 看了题解发现正着来也很简单，自己实现了一下
        // int rightest = 0;
        // for (int i = 0; i <= rightest; i++) {
        //     rightest = Math.max(rightest, i + nums[i]);
        //     if (rightest >= nums.length - 1)
        //         return true;
        // }
        // return false;
    }
}