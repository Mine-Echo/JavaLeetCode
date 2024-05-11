class LeetCode240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        //从右上角往左/往下搜索
        int x=0,y=matrix[0].length-1;
        while (x<matrix.length&&y>=0) {
            if(matrix[x][y] < target){
                    x++;
            }         
            else if(matrix[x][y] > target){
                    y--;
            }
            else if(matrix[x][y]==target)
                return true;
        }
        return false;
    }
    public static void main(String[] args){
    }
}