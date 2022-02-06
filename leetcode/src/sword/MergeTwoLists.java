package sword;

import basic.ListNode;

/**
 * <p>
 * 剑指 Offer 25. 合并两个排序的链表
 * </p>
 *
 * @author mohe
 * @date 2022-02-06 13:13:52
 */
public class MergeTwoLists {

    /**
     * 递归解法
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode head = null;
        if (l1.val < l2.val) {
            head = l1;
            head.next = mergeTwoListsRecursive(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoListsRecursive(l1, l2.next);
        }
        return head;
    }

    /**
     * 循环解法
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsLoop(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        ListNode dummy = new ListNode(-999);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null)
            cur.next = l1;
        else
            cur.next = l2;
        return dummy.next;
    }
}
