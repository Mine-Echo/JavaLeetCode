
//最小栈
import java.util.*;

class MinStack {

    private Stack<Integer> stack;
    private ArrayList<Integer> min;

    public MinStack() {
        stack = new Stack<>();
        min = new ArrayList<>();
    }

    public void push(int val) {
        stack.push(val);
        if (min.isEmpty())
            min.add(val);
        else {
            int lastMin = min.get(min.size() - 1);
            min.add(lastMin < val ? lastMin : val);
        }
    }

    public void pop() {
        stack.pop();
        min.remove(min.size() - 1);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.get(min.size() - 1);
    }
}