/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 
 TC - O(n log k)
 SC - O(k)
 
 Input: lists = [[1,4,5],[1,3,4],[2,6]]
 
 dummy = -1 -> 1 -> 1
                   cur 
 
  2 
 4 3
 
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0)
            return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode l1, ListNode l2) -> l1.val - l2.val);
        
        int i = 0;
        
        while(i < lists.length){
            if(lists[i]!=null)
                pq.offer(lists[i]);
            i++;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            cur.next = node;
            cur = cur.next;
            
            if(node.next!=null)
                pq.offer(node.next);
        }
        
        return dummy.next;
    }
}