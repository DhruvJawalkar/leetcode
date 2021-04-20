/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 
 Ex: l1 = [9,9,9,9,9,9,9], 
     l2 = [9,9,9,9]
          [8,9,9,9,0,0,0]  
          
 TC - O(n), where n is the larger of the lists
 SC - O(n)
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        
        int sum = 0, carry = 0;
        while(ptr1!=null || ptr2!=null){
            if(ptr1!=null)
                sum += ptr1.val;
            if(ptr2!=null)
                sum += ptr2.val;
            
            sum += carry;
            
            result.next = new ListNode(sum%10);
            result = result.next;
            
            if(sum>9)
                carry = 1;
            else
                carry = 0;    
            
            if(ptr1!=null)
                ptr1 = ptr1.next;
            if(ptr2!=null)
                ptr2 = ptr2.next;
            
            sum = 0;
        }
        
        if(carry>0)
            result.next = new ListNode(carry);
        
        return dummy.next;
    }
}