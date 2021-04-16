/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head==null)
            return head;
        
        Node cur = head;
        
        while(cur!=null){
            if(cur.child!=null){
                Node subHead = flatten(cur.child);    
                Node tail = subHead;
                
                while(tail.next!=null)
                    tail = tail.next;
                
                tail.next = cur.next;    
                if(cur.next!=null){
                    cur.next.prev = tail;
                }
                
                cur.next = subHead;
                subHead.prev = cur;
                cur.child = null;
                cur = tail;
            }
            
            cur = cur.next;
        }
        
        return head;
    }
}