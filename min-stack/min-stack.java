class MinStack {
    Stack<int[]> stack;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int x) {
        //if stack not empty push [x, min(x, stack.peek()[1])]
        if(!stack.isEmpty()){
            int[] top = stack.peek();
            stack.push(new int[]{x, Math.min(top[1], x)});
        }
        
        //else push [x, x]
        else
            stack.push(new int[]{x, x});
    }
    
    public void pop() {
        //if stack not empty just call pop()
        if(!stack.isEmpty())
            stack.pop();
    }
    
    public int top() {
        //if stack not empty peek() top element and return e[0]
        if(!stack.isEmpty())
            return stack.peek()[0];
        
        else return -1;
    }
    
    public int getMin() {
        //if stack not empty, return stack.peek()[1]
        if(!stack.isEmpty())
            return stack.peek()[1];
        else return -1;
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