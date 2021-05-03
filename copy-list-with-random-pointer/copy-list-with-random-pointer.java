/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

Ex: 1  1  2  2  null
         cur
                   temp
                   
TC - O(n), 3 iterations
SC - O(n)
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        
        Node cur = head;
        Node temp;
        //make a copy of the node and insert in between 
        while(cur!=null){
            Node newNode = new Node(cur.val);
            temp = cur.next;
            cur.next = newNode;
            newNode.next = temp;
            
            cur = temp;
        }
        
        //store new node head
        Node newHead = head.next;
        
        //now connect random to new nodes
        cur = head;
        while(cur!=null){
            if(cur.random!=null)
                cur.next.random = cur.random.next;
            
            cur = cur.next.next;
        }
        
        //link separate old nodes from new nodes
        cur = head;
        while(cur!=null){
            temp = cur.next.next;
            
            cur.next.next = (temp!=null) ? temp.next : null;
            
            cur.next = temp;
            
            cur = temp;
        }
        
        //return new head
        return newHead;
    }
}