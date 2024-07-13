//矩阵置零
public class LeetCode73 {
    public void setZeroes(int[][] matrix) {
        // 方法1：直接新建一个矩阵，空间复杂度O(mn)，实现略
        // 方法2：标记某行某列需要置零，空间复杂度O(m+n)，实现略

        // 方法3：原地置零，我的想法是直接用矩阵的第一行和第一列模拟方法2
        // 标记
        boolean firstRow = false, firstCol = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0)
                        firstRow = true;
                    if (j == 0)
                        firstCol = true;
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        // 置零
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        if (firstRow) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] =0;
            }
        }
        if (firstCol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] =0;
            }
        }
    }
}
