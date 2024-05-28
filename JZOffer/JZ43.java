//整数中1出现的次数

public class JZ43 {
    public int NumberOf1Between1AndN_Solution(int n) {
        //时间复杂度很高的做法
        // int cnt=0;
        // for(int i=0;i<=n;i++){
        //     String str=Integer.toString(i);
        //     for(int j=0;j<str.length();j++){
        //         if(str.charAt(j)=='1')
        //             cnt++;
        //     }
        // }
        // return cnt;
        
        //网上看到的方法，很巧妙
        //每次都算最高位1的数量，然后除去最高位，一直递归下去
        if(n==0) return 0;
        if(n<10) return 1;
        int high=n,pow=1;//最高位和最高位的权重
        while(high>=10){
            high=high/10;
            pow*=10;
        }
        //位数和n一样且最高位为high的数
        int num=n-high*pow+1;
        int numOf1=0;
        if(high==1)//最高位为1
            numOf1 = num;
        else    //最高位不为1
            numOf1=pow;
        //比如2015
        //最高位1的个数(1000)+Numof(15)+2*numof(999)
        return numOf1+NumberOf1Between1AndN_Solution(num-1)+high*NumberOf1Between1AndN_Solution(pow-1);

    }
}
