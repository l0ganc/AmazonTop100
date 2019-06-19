package Day3;

import java.util.PriorityQueue;
import java.util.Stack;

public class LC155MinStack {
    /**
     * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
     *
     * push(x) -- Push element x onto stack.
     * pop() -- Removes the element on top of the stack.
     * top() -- Get the top element.
     * getMin() -- Retrieve the minimum element in the stack.
     * Example:
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin();   --> Returns -3.
     * minStack.pop();
     * minStack.top();      --> Returns 0.
     * minStack.getMin();   --> Returns -2.
     */

    Stack<Integer> stack;
    PriorityQueue<Integer> pq;
    /** initialize your data structure here. */
    public LC155MinStack() {
        stack = new Stack<>();
        pq = new PriorityQueue<>();
    }

    public void push(int x) {
        stack.push(x);
        pq.add(x);
    }

    public void pop() {
        int num = stack.pop();
        if (pq.peek() == num) {
            pq.poll();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return pq.peek();
    }
}
