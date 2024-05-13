
//二进制中1的个数
public class JZ15 {
        /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param n int整型 
     * @return int整型
     */
    public int NumberOf1 (int n) {
        // write code here
        // int count = 0;
        // String bin=Integer.toBinaryString(n);
        // for(int i=0;i<bin.length(); i++){
        //     if(bin.charAt(i)=='1')
        //         ++count;
        // }
        // return count;
        //不用转成binString，数在计算机内本身就是用二进制存储的，直接用用&
        int count=0,temp=n;
        while(temp!=0){
            if((temp&1)>0)
                count++;
            temp=temp>>>1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-1));
    }
}
