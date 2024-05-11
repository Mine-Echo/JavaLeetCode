

public class JZ11 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param array int整型一维数组 
     * @return int整型
     */
    public int minNumberInRotateArray (int[] array) {
        // write code here
        //暴力搜索，还可以用二分查找
        // int min=0;
        // for (int i = 0; i <array.length;i++){
        //     if(i==0)
        //         min=array[0];
        //     else if(min>array[i])
        //         min=array[i];
        // }
        // return min;

        int low = 0 ; int high = array.length - 1;    
        while(low < high){
            int mid = low + (high - low) / 2;         
            if(array[mid] > array[high]){
                low = mid + 1;
            }else if(array[mid] == array[high]){
                high = high - 1;
            }else{
                high = mid;
            }    
        } 
        return array[low];
    }
}