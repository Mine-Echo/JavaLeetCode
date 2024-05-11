//用两个栈模拟一个队列


import java.util.Stack;

public class JZ9 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    //在push的时候进行操作达到队列效果，pop的时候直接pop
    //也可以在push的时候直接push，pop的时候进行操作达到队列效果
    public void push(int node) {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(node);
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
    }

    public int pop() {
        return stack1.pop();
    }
}
