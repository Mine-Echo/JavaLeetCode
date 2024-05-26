//字符串的排序
import java.util.*;

public class JZ38 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param str string字符串 
     * @return string字符串ArrayList
     */
    // //复杂度太高了，长度为9的用例超时了
    // public ArrayList<String> Permutation (String str) {
    //     // write code here
    //     ArrayList<String> result=new ArrayList<>();
    //     if(str==null)
    //         return result;
    //     if(str.length()<=1){
    //         result.add(str);
    //         return result;
    //     } 
    //     for(int i=0;i<str.length();i++){
    //         String ch=str.substring(i, i+1);
    //         ArrayList<String> list=Permutation(str.substring(0,i)+str.substring(i+1));
    //         list.forEach(s->{
    //             if(!result.contains(ch+s))
    //                 result.add(ch+s);
    //         });
    //     }
    //     return result;
    // }


    //网上看到的方法，将str转换为char数组，再用dfs
    private ArrayList<String> result=new ArrayList<>();
    private char[] c;
    public ArrayList<String> Permutation (String str) {
        // write code here
        c=str.toCharArray();
        dfs(0);
        return result;
    }
    private void dfs(int index){
        if(index==c.length-1){
            result.add(String.valueOf(c));
            return;
        }
        Set<Character> set=new HashSet<>();
        for(int j=index;j<c.length;j++){
            if(!set.contains(c[j])){
                set.add(c[j]);
                swap(index,j);
                dfs(index+1);
                //交换回去
                swap(index,j);
            }
        }
    }
    private void swap(int index1, int index2){
        char tmp=c[index1];
        c[index1]=c[index2];
        c[index2]=tmp;
    }
}