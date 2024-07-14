//删除有序数组中的重复项2

public class LeetCode80 {
    public int removeDuplicates(int[] nums) {
        //还是用双指针法
        if(nums.length<=2)
            return nums.length;
        int left=2,right=2;
        for(;right<nums.length;right++){
            // if(nums[right]!=nums[left-1]||nums[left-1]!=nums[left-2]){
            if(nums[left-2]!=nums[right]){//判断条件可以简化成这样，我写的判断条件还是复杂了一点
                nums[left++]=nums[right];
            }
        }
        return left;
    }
}