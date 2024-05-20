//顺时针打印矩阵
import java.util.*;
public class JZ29 {
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        //顺时针一圈一圈扫描，稍微有点复杂，必须每次扫描完一行/列都进行一次判断是否完成，否则会出现重复
        if (matrix.length==0)
            return null;
        int row1=0,row2=matrix.length-1,col2=matrix[0].length-1,col1 = 0;
        ArrayList<Integer> arrayList =new ArrayList<>();
        while(true){
            int i,j;
            for(i=row1,j=col1;j<=col2;j++){
                arrayList.add(matrix[i][j]);
            }
            ++row1;
            if(row1>row2||col1>col2)
                break;
            for(j=col2,i=row1;i<=row2;i++){
                arrayList.add(matrix[i][j]);
            }
            --col2;
            if(row1>row2||col1>col2)
                break;
            for(i=row2,j=col2;j>=col1;j--){
                arrayList.add(matrix[i][j]);
            }
            --row2;
            if(row1>row2||col1>col2)
                break;
            for(j=col1,i=row2;i>=row1;i--){
                arrayList.add(matrix[i][j]);
            }
            col1++;
            if(row1>row2||col1>col2)
                break;
        }
        return arrayList;
    }
    public static void main(String[] args) {
        int[][] matrix=new int[][]{ {1,2,3,1}};
        System.out.println(matrix[0][0]);
        List<Integer> list=printMatrix(matrix);
        System.out.println(list);
    }
}