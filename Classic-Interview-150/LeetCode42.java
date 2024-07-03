//接雨水

public class LeetCode42 {
    public int trap(int[] height) {
        // 网上看到的很牛的思路：每根柱子能接受的雨水量取决于min(left,right)
        // int[] left = new int[height.length];
        // left[0] = height[0];
        // for (int i = 1; i < height.length; i++) {
        //     // 这里我让左右最大都包括本身，最后减去height[i]的时候就不需要判断小于0
        //     left[i] = Math.max(left[i - 1], height[i]);
        // }
        // int[] right = new int[height.length];
        // right[height.length - 1] = height[height.length - 1];
        // for (int i = height.length - 2; i >= 0; i--) {
        //     right[i] = Math.max(right[i + 1], height[i]);
        // }
        // int cnt = 0;
        // for (int i = 0; i < height.length; i++) {
        //     cnt += Math.min(left[i], right[i]) - height[i];
        // }
        // return cnt;

        // 双指针法，用指针代替上面的两个数组，将空间复杂度降低为O1
        // 假设左右两柱子分别为 i，j。那么就有 iLeftMax,iRightMax,jLeftMx,jRightMax 这个变量。由于 j>i ，故
        // jLeftMax>=iLeftMax，iRigthMax>=jRightMax.
        // 那么，如果 iLeftMax>jRightMax，则必有 jLeftMax >= jRightMax，所有我们能接 j 点的水。
        // 如果 jRightMax>iLeftMax，则必有 iRightMax >= iLeftMax，所以我们能接 i 点的水。
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int cnt = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax > rightMax) {
                cnt += rightMax - height[right];
                right--;
            } else {
                cnt += leftMax - height[left];
                left++;
            }
        }
        return cnt;
    }
}
