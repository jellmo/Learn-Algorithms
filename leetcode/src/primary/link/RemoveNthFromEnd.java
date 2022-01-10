package primary.link;

/**
 * <p>
 * 删除链表的倒数第N个节点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 * </p>
 * <p>
 * 思路：
 * 1. 先判断链表长度，找到倒数第n个结点，然后删除（注意删除时需要操作前一个结点，而非当前结点）
 * 2. 一趟扫描，快慢指针间隔n，当快指针遍历到null时，慢指针就刚好到倒数第n个结点
 *
 * @author mohe
 * @date 2022-01-10 13:11:07
 */
public class RemoveNthFromEnd {

    /**
     * 解法1：双层遍历
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEndOne(ListNode head, int n) {

        int num = getLength(head) - n;
        if (num == 0) {
            return head.next;
        }
        ListNode node = head;
        for (int i = 0; i < num - 1; i++) {
            node = node.next;
        }
        node.next = node.next.next;
        return head;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    /**
     * 解法2：快慢指针
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEndTwo(ListNode head, int n) {

        //一个不带值的头节点，方便操作
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //slow指向倒数第n+1个结点
        slow.next = slow.next.next;
        return dummy.next;
    }
}
