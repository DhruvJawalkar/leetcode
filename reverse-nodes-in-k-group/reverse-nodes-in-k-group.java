/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 
 TC - O(n)
 SC - O(n/k)
 
 Ex: head = [1, 2, 3, 4, 5], k = 2
             2 ->1 -> 4 -> 3 -> 5 
          
       revHead      
                  ptr 
                 temp
                  cur
   counter = 0
           
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        //base case
        if(head==null || head.next==null || k==1)
            return head;
        
        //check if k nodes exist
        ListNode cur = head;
        int counter = k;
        while(cur!=null && counter>0){
            cur = cur.next;
            counter--;
        }
        
        if(counter>0)
            return head;

        //reverse
        ListNode revHead = head;
        ListNode ptr = head.next;
        ListNode temp;
        counter = k-1;
        
        while(counter>0){
            temp = ptr.next;
            ptr.next = revHead;
            revHead = ptr;
            
            ptr = temp;
            counter--;
        }
        
        //call recursion on the tail
        head.next = reverseKGroup(ptr, k);
        
        return revHead;
    }
}