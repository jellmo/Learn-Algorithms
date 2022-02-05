package sword;

import basic.ListNode;

/**
 * <p>
 * 剑指 Offer 18. 删除链表的节点
 * </p>
 * <p>
 * 思路： 双指针遍历
 *
 * @author mohe
 * @date 2022-02-05 16:28:21
 */
public class DeleteNode {

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null)
            return null;
        if (head.val == val)
            return head.next;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if (cur == null)
            return head;
        pre.next = cur.next;
        return head;
    }
}
