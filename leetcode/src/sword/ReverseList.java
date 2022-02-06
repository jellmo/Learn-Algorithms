package sword;

import basic.ListNode;

/**
 * <p>
 * 剑指 Offer 24. 反转链表
 * </p>
 *
 * @author mohe
 * @date 2022-02-06 12:52:50
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode fast = cur.next;
            cur.next = pre;
            pre = cur;
            cur = fast;
        }
        return pre;
    }
}
