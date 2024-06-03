//左旋转字符串
public class JZ58 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param str string字符串 
     * @param n int整型 
     * @return string字符串
     */
    public String LeftRotateString (String str, int n) {
        // write code here
        if(str.length()==0)
            return str;
        n=n%(str.length());
        StringBuilder sb=new StringBuilder(str);
        sb.append(str.substring(0, n));
        sb.delete(0,n);
        return sb.toString();
    }
}