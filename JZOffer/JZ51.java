//数组中的逆序对
public class JZ51 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param nums int整型一维数组 
     * @return int整型
     */

    private int cnt=0;
    public int InversePairs (int[] nums) {
        // write code here
        //On^2的方法
        // int cnt = 0;
        // for (int i =0;i < nums.length;i++){
        //     for(int j=i+1;j < nums.length;j++){
        //         if(nums[i]>nums[j])
        //             ++cnt;
        //     }
        //     cnt%=1000000007;
        // }
        // return cnt;
        
        //看了网上的思路,用归并排序，排序的时候统计逆序对数量，自己实现了一下
        //我感觉理论上用ologn复杂度基于比较的排序算法，在排序的时候统计逆序对数量都可以做；但实际上还是归并比较好做，别的感觉没那么容易统计数量
        cnt=0;
        mergeSort(nums, 0, nums.length);
        return cnt;
    }

    private int[] mergeSort(int[] nums, int begin, int end) {
        int[] result = new int[end-begin];
        if(end-begin==1){
            result[0]=nums[begin];
            return result;
        }
        int boundary=(begin+end)/2;
        int[] left=mergeSort(nums, begin, boundary);
        int[] right=mergeSort(nums,boundary,end);
        //统计逆序对数量
        //归并
        int i=0,j=0,z=0;
        while(i<left.length&&j<right.length){
            if(left[i]<=right[j]){
                result[z++]=left[i++];
            }else{
                cnt+=(boundary-begin)-i;
                result[z++] =right[j++];
            }
        }
        while (i<left.length) {
            result[z++] =left[i++];
        }
        while(j<right.length){
            result[z++]=right[j++];
        }
        cnt%=1000000007;
        return result;
    }
}