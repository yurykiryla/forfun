package problems.p155;

/**
 * https://leetcode.com/problems/min-stack/description/
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum element 
 * in constant time.
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * @author yuryk
 *
 */
public class MinStack {
    private Entry top;

    /** initialize your data structure here. */
    public MinStack() {
        top = null;
    }
    
    public void push(int x) {
        top = new Entry(x, top);
        if (top.next == null || x < top.minValue) {
            top.minValue = x;
        }
    }
    
    public void pop() {
        top = top.next;
    }
    
    public int top() {
        return top.value;
    }
    
    public int getMin() {
        return top.minValue;
    }
    
    private static class Entry {
        int minValue;
        int value;
        Entry next = null;
        Entry(int value, Entry next) {
            this.value = value;
            this.next = next;
            if (next != null) {
                minValue = next.minValue;
            }
        } 
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */