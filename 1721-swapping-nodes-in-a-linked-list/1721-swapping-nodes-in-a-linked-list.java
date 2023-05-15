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
    public ListNode swapNodes(ListNode head, int k) {
        if(head.next == null) return head;
        
        int len = 0;
        
        ListNode iterator = head;
        while(iterator != null){
            ++len;
            iterator = iterator.next;
        }
        
        int fromHead = k;
        int fromTail = len - k + 1;
        
        ListNode first = null;
        ListNode second = null;
        
        int count = 0;
        iterator = head;
        
        while(iterator != null && (first == null || second == null)){
            ++count;
            
            if(count == fromHead) first = iterator;
            if(count == fromTail) second = iterator;
            
            iterator = iterator.next;
        }
        
        int val = first.val;
        first.val = second.val;
        second.val = val;
        
        return head;
    }

}