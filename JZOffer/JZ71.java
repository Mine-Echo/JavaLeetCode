public class JZ71 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param number int整型 
     * @return int整型
     */
    public int jumpFloorII (int number) {
        // write code here
        // if(number == 1||number == 2)
        //     return number;
        // int[] arr=new int[number+1];
        // arr[0] = 1;
        // arr[1] = 1;
        // arr[2] = 2;
        // for(int i=3;i <= number; ++i){
        //     for(int j=0;j<i;j++)
        //         arr[i]+=arr[j];
        // }
        // return arr[number];

        //再次简化就是2*jumpFloorII(number-1);
        // if(number ==1)
        //     return 1;
        // return 2*jumpFloorII(number-1);

        //再简化
        return 1<<(number-1);
    }
}