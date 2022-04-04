package list;


public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(-1);
        ListNode head = l3;
        boolean needAddOne = false;
        while (l1 != null || l2 != null) {
            int res = 0;
            if (l1 != null && l2 != null) {
                res = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            } else {
                if (l1 != null) {
                    res = l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    res = l2.val;
                    l2 = l2.next;
                }
            }
            res = needAddOne ? res + 1 : res;
            needAddOne = res >= 10;
            head.next = new ListNode(res % 10);
            head = head.next;
        }
        // 假如所有的都处理完成，此时如果needAddOne还为true则默认加一
        if (needAddOne) {
            head.next = new ListNode(1);
            head = head.next;
        }
        head = l3.next;
        return head;
    }
public static void main(String[] args) {
    System.out.println(9 % 10);
}
}
