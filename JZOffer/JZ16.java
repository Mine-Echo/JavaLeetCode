//整数的整数次方
public class JZ16 {
    public double Power(double base, int exponent) {
        //方法一：一步一步递乘
        // double ret=1;
        // for(int i=1;i <= Math.abs(exponent); i++){
        //     ret*=base;
        // }
        // if(exponent<0)
        //     ret=1.0/ret;
        // return ret;

        /**
         * 更快的方法：快速幂
         * 可以用二进制理解
         * exponent=5=0101
         * base^1*base^4
         */
        int ex=Math.abs(exponent);
        double ret=1;
        while(ex != 0){
            if ((ex&1)!=0)
                ret*=base;
            base*=base;
            ex=ex>>1;
        }
        if(exponent < 0)
            ret=1/ret;
        return ret;
    }
}
