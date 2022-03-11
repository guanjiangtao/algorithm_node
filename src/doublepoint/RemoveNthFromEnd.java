package doublepoint;


public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode listNode = new ListNode(0 ,head);
        // 获取所有的长度
        int length = getLength(head);
        ListNode cur = listNode;
        // 链表跳转到待删除的前一个
        for (int i = 1; i <= length - n; ++i) {
            cur = cur.next;
        }
        // 删掉待删除那个（接好）
        cur.next = cur.next.next;
        // 重新复制
        ListNode ans = listNode.next;
        return ans;
    }

    public int getLength(ListNode head) {
        int i = 0;
        while (head != null) {
            ++i;
            head = head.next;
        }
        return i;
    }
}
