class BrowserHistory {
    class DLLNode{
        String url;
        DLLNode prev;
        DLLNode next;
        
        DLLNode(){}
        
        DLLNode(String pageUrl){
            url = pageUrl;
        }
    }
    
    DLLNode head, cur;
    //head
    //                                             cur
    //leetcode.com->google.com->facebook.com->linkedin.com 
    
    public BrowserHistory(String homepage) {
        head = new DLLNode(homepage);
        cur = head;
    }
    
    public void visit(String url) {
        DLLNode newNode = new DLLNode(url);
        
        cur.next = newNode;
        newNode.prev = cur;
        
        cur = cur.next;
    }
    
    public String back(int steps) {
        while(steps>0 && cur.prev!=null){
            cur = cur.prev;
            steps--;
        }
        
        return cur.url;
    }
    
    public String forward(int steps) {
        while(steps>0 && cur.next!=null){
            cur = cur.next;
            steps--;
        }
        
        return cur.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */