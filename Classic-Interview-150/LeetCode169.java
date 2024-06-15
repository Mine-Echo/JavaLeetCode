//多数元素

class Solution {
    public int majorityElement(int[] nums) {
        //之前做过这道题，可以用摩尔投票法
        int ret=nums[0];
        int count=1;
        for (int i = 1; i < nums.length; i++) {
            if(count==0)
                ret=nums[i];
            if(ret==nums[i]){
                count++;
            }else{
                count--;
            }
        }
        return ret;
    }
}