
//螺旋矩阵
import java.util.List;
import java.util.ArrayList;

public class LeetCode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        // 之前做过，轻松拿下
        List<Integer> result = new ArrayList<Integer>();
        int lowerRow = 0, upperRow = matrix.length - 1, lowerCol = 0, upperCol = matrix[0].length - 1;
        while (true) {
            for (int i = lowerCol; i <= upperCol; i++) {
                result.add(matrix[lowerRow][i]);
            }
            lowerRow++;
            if (lowerRow > upperRow)
                break;
            for (int i = lowerRow; i <= upperRow; i++) {
                result.add(matrix[i][upperCol]);
            }
            upperCol--;
            if (lowerCol > upperCol)
                break;
            for (int i = upperCol; i >= lowerCol; i--) {
                result.add(matrix[upperRow][i]);
            }
            upperRow--;
            if (lowerRow > upperRow)
                break;
            for (int i = upperRow; i >= lowerRow; i--) {
                result.add(matrix[i][lowerCol]);
            }
            lowerCol++;
            if (lowerCol > upperCol)
                break;
        }
        return result;
    }
}
