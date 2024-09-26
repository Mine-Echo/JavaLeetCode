// 将有序数组转化为二叉搜索树
public class LeetCode108 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArray2BST(nums, 0, nums.length);
    }

    private TreeNode sortedArray2BST(int[] nums, int begin, int end) {
        if (begin == end) {
            return null;
        }
        int mid = (begin + end) / 2;
        TreeNode ret = new TreeNode(nums[mid]);
        ret.left = sortedArray2BST(nums, begin, mid);
        ret.right = sortedArray2BST(nums, mid + 1, end);
        return ret;
    }
}
