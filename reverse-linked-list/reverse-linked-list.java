/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 
 
Ex:  null <- 1 <- 2

Ex: null <- 1 <- 2 <- 3  null         
                    prev
                         cur
                        temp  
    1  2 <- 3 
Iterative    
TC - O(n)
SC - O(1)

Recursive    
TC - O(n)
SC - O(n)
 */
class Solution {    
    private ListNode iterative(ListNode head){
        if(head==null || head.next==null)
            return head;
        
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp;
        
        while(cur!=null){
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        
        return prev;        
    }
    
    private ListNode recursive(ListNode node){        
        if(node.next==null)
            return node;
        
        ListNode head = recursive(node.next);
        node.next.next = node;
        node.next = null;
        
        return head;
    }
    
    
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        
        return recursive(head);
    }
}