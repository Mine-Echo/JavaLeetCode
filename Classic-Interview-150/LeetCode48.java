//旋转图像

public class LeetCode48 {
    public void rotate(int[][] matrix) {
        // 原地旋转图像
        // 网上看到的很牛的思路：先按照对角线翻转，然后逐行翻转
        int n = matrix.length;
        // 对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                swap(matrix, i, j, j, i);
            }
        }
        // 逐行翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                swap(matrix, i, j, i, n-j-1);
            }
        }
    }

    private void swap(int[][] matrix, int i, int j, int k, int l) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[k][l];
        matrix[k][l] = temp;
    }
}
