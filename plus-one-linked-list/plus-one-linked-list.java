/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        
        ListNode cur = head;
        Stack<ListNode> stack = new Stack<>();
        
        while(cur.next!=null){
            stack.push(cur);
            cur = cur.next;
        }
        
        cur.val = cur.val+1;
        
        while(!stack.isEmpty() && cur.val==10){
            cur.val = 0;
            cur = stack.pop();
            cur.val = cur.val + 1;
        }
        
        if(stack.isEmpty() && cur.val==10){
            cur.val = 0;
            ListNode dummy = new ListNode(1);
            dummy.next = cur;
            return dummy;
        }
        
        return head;
    }
}