public class LeetCode11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            max = Math.min(height[left], height[right]) * (right - left) > max
                    ? Math.min(height[left], height[right]) * (right - left)
                    : max;
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
