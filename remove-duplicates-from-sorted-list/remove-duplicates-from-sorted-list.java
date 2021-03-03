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
    public ListNode deleteDuplicates(ListNode head) {
        //base cases
        if(head==null || head.next==null)
            return head;
        
        //initialize curVal, initialize cur=head, prev=null
        int curVal=head.val;
        ListNode cur=head.next, prev=head;
        
        //iterate over LL, if node.val!=curVal, update curVal and continue, prev=cur, cur=cur.next
        //else set prev.next=cur.next, cur=cur.next
        while(cur!=null){
            if(cur.val!=curVal){
                curVal=cur.val;
                prev=cur;
                cur=cur.next;
            }
            else{
                prev.next=cur.next;
                cur=cur.next;
            }
        }
        
        //return head 
        return head;
    }
}