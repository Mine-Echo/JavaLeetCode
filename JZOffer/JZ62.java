//圆圈中最后剩下的数
public class JZ62 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param n int整型 
     * @param m int整型 
     * @return int整型
     */
    public int LastRemaining_Solution (int n, int m) {
        // write code here
        //用数组模拟整个过程，也可以用链表模拟，时间复杂度比较高
        // int[] children=new int[n];
        // for(int i=0;i<n;i++){
        //     children[i]=i;
        // }
        // int index=0;
        // //删除n-1个
        // for(int i=0;i<n;i++){
        //     int cnt=m;
        //     while(cnt>1){
        //         if(children[index++]!=-1){
        //             cnt--;
        //         }
        //         index%=n;
        //     }
        //     while (children[index]==-1){
        //         index++;
        //         index%=n;
        //     }
        //     //删除
        //     children[index]=-1;
        // }
        // return index;

        //约瑟夫环问题，
        //递归公式为f(n,m)=(f(n-1,m)+m)%n，f(1,m)=0
        //n为总人数，m为报道m的人出列（从1开始报），f(n,m)为胜利者下标（从0开始）
        //原理就是每出列一个人，胜利者的坐标就循环向前移动了m，最后只剩一个人时下标肯定是0，然后逆推回去就可以了
        //复杂度为On
        int index = 0;
        for(int i=2;i<=n;i++){
            index=(index+m)%i;
        }
        return index;
    }
}