//不用加减乘除做加法
public class JZ65 {
    public int Add(int num1,int num2) {
        //网上的思路
        //模拟二进制加法，用&和^实现
        //^是每一位不算进位相加
        //&是每一位的进位
        //&左移一位+^
        while(num2!=0){
            int sum=num1^num2;
            int carry=(num1&num2)<<1;
            num1=sum;
            num2=carry;
        }
        return num1;
    }
}