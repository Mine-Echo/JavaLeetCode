//栈的压入弹出序列

import java.util.Stack;

public class JZ31 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param pushV int整型一维数组 
     * @param popV int整型一维数组 
     * @return bool布尔型
     */
    public boolean IsPopOrder (int[] pushV, int[] popV) {
        // write code here
        int i=0,j=0;
        Stack<Integer> stack = new Stack<>();
        while(true){
            if(stack.empty()||stack.peek()!=popV[j]){
                if(i<pushV.length)
                    stack.push(pushV[i++]);
                else
                    return false;
            }
            else{
                stack.pop();
                if(j==popV.length-1)
                    return true;
                else
                    j++;
            }   
        }
    }
}
