class MyQueue {
    Stack<Integer> s1, s2;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
        //use s2 to maintain queue order of elements, return top element with O(1) for peek() and pop()
    }
    
    /** Push element x to the back of queue. */
    //for push if s2 not empty unload all elements from s2 into s1, complete push and unload all from s1 to s2
    //O(2N)
    public void push(int x) {
        if(!s2.isEmpty()){
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        
        s1.push(x);
        
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!empty())
            return s2.pop();
        return -1;
    }
    
    /** Get the front element. */
    public int peek() {
        if(!empty())
            return s2.peek();
        return -1;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */