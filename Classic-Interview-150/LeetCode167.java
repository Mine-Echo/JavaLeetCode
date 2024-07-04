//两数之和：输入有序数组

public class LeetCode167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int[] result =new int[2];
        while (left < right) {
            if(numbers[left]+numbers[right]<target){
                left++;
            }else if(numbers[right]+numbers[left]>target){
                right--;
            }else{
                result[0]=left+1;
                result[1]=right+1;
                return result;
            }
        }
        return result;
    }
}
