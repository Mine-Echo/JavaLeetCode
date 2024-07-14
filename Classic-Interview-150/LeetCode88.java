//合并两个有序数组

public class LeetCode88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 经典merge
        // 不过这题有一个空间复杂度为O1的算法
        // 因为这题是合并到nums1，只要从后往前合并就不用额外的数组
        int p1 = m - 1, p2 = n - 1, p = n + m - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] <= nums2[p2]) {
                nums1[p--]=nums2[p2--];
            } else {
                nums1[p--]=nums1[p1--];
            }
        }
        while(p1>=0){
            nums1[p--]=nums1[p1--];
        }
        while(p2>=0){
            nums1[p--]=nums2[p2--];
        }
    }
}