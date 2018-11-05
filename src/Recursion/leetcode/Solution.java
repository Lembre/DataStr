package Recursion.leetcode;/// Leetcode 203. Remove Linked List Elements
/// https://leetcode.com/problems/remove-linked-list-elements/description/

class Solution {

    public ListNode removeElements(ListNode head, int val) {

        while(head != null && head.val == val){
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }/*先解决特殊情况，要是删除头结点之后，还相等，那么继续删除*/

        if(head == null)/*如果全部节点都为那个值*/
            return head;

        ListNode prev = head;
        while(prev.next != null){/*还没有遍历到最后一个节点*/
            if(prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }
            else
                prev = prev.next;
        }

        return head;
    }
}