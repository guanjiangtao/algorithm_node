package day5;

import java.util.List;

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

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        ListNode[] listNodes = new ListNode[100];
        int i = 0;
        while (head != null) {
            listNodes[i++] = head;
            head = head.next;
        }
        return listNodes[i/2];
    }

    /**
     * 快慢指针 from leetcode
     * @param head
     * @return
     */
    public ListNode middleNode1(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
