//包含min函数的栈
import java.util.Stack;
public class JZ30 {
    // 下面是 一种pop时间复杂度为On的算法，实在不知道怎么写
    // private Stack<Integer> s=new Stack<>();;
    // private int m=10000;
    // public void push(int node) {
    //     s.push(node);
    //     if (node<m) {
    //         m=node;
    //     }
    // }
    // public void pop() {
    //     if(s.peek()==m){
    //         s.pop();
    //         m=10000;
    //         s.forEach(n->{
    //             m=m<n?m:n;
    //         });
    //     }else
    //         s.pop();
    // }
    // public int top() {
    //     return s.peek();
    // }
    // public int min() {
    //     return m;
    // }


    //看了阿秀笔记上的解法
    //大致思想就是维持两个栈，一个栈用来PUSH POP，另一个栈用来记录前一个栈每个状态下的最小值信息
    private Stack<Integer> s=new Stack<>();
    private Stack<Integer> min=new Stack<>();
    public void push(int node) {
        s.push(node);
        if((!min.isEmpty())&&min.peek()<node){
            min.push(min.peek());
        }else
            min.push(node);
    }
    public void pop() {
        s.pop();
        min.pop();
    }
    public int top() {
        return s.peek();
    }
    public int min() {
        return min.peek();
    }
}

