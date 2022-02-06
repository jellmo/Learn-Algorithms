package sword;

import basic.ListNode;

/**
 * <p>
 * 剑指 Offer 22. 链表中倒数第k个节点
 * </p>
 *
 * @author mohe
 * @date 2022-02-06 10:42:07
 */
public class GetKthFromEnd {

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k <= 0)
            return null;
        ListNode pre = head;
        for (int i = 0; i < k - 1; i++) {
            if (pre == null)
                return null;
            pre = pre.next;
        }
        ListNode cur = head;
        while (pre.next != null) {
            cur = cur.next;
            pre = pre.next;
        }
        return cur;
    }
}
