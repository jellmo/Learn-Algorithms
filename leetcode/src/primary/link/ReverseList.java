package primary.link;

/**
 * <p>
 * 反转链表     (难度: easy)
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * </p>
 * <p>
 * 思路：
 * 1. 倒排，用指针指向结点，然后反转结点的next指针
 * 2. 创建另一个单链表
 *
 * @author mohe
 * @date 2022-01-11 20:05:39
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        return pre;
    }

    /**
     * 头插法新建单链表
     */
    public ListNode reverseList_Two(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1, null);
        ListNode cur = head;
        while (cur != null) {
            //记录下一个结点
            ListNode nextTemp = cur.next;

            //头插法
            ListNode temp = dummy.next;
            cur.next = temp;
            dummy.next = cur;

            //指针下移
            cur = nextTemp;
        }
        return dummy.next;
    }
}
