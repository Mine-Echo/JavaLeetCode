//跳跃游戏II
class Solution {
    public int jump(int[] nums) {
        // 可以反着来，时间复杂度有点高，On2
        // int index = nums.length - 1;
        // int cnt = 0;
        // while (index > 0) {
        // int nextIndex = 0;
        // for (int i = index - 1; i >= 0; i--) {
        // if (nums[i] + i >= index) {
        // nextIndex = i;
        // }
        // }
        // index = nextIndex;
        // cnt++;
        // }
        // return cnt;

        // 看了题解，发现上面哪个方法也是题解给出的一个方法
        // 下面这个方法是题解给出的另一个方法，时间复杂度为On
        // 正向查找，每次记录可以最远到达的位置
        int cnt = 0;
        int boundIndex = 0;
        int nextBoundIndex = 0;
        for (int i = 0; i <= boundIndex; i++) {
            if (boundIndex >= nums.length - 1) {
                break;
            }
            if (i + nums[i] > nextBoundIndex)
                nextBoundIndex = i + nums[i];
            if (i == boundIndex) {
                boundIndex = nextBoundIndex;
                cnt++;
            }
        }
        // 下面是官方的具体实现，写的比我的简洁一些
        // <nums.length-1改成<numslength的话刚好走到终点的情况下会多计算一步
        // for(int i=0;i<nums.length-1;i++){
        //     nextBoundIndex=Math.max(nextBoundIndex,i+nums[i]);
        //     if(i==boundIndex){
        //         boundIndex=nextBoundIndex;
        //         cnt++;
        //     }
        // }
        return cnt;
    }
}