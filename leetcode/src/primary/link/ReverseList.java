package primary.link;

/**
 * <p>
 * 反转链表     (难度: easy)
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * </p>
 * <p>
 * 思路：
 * 1. 倒排，用指针指向结点，然后反转结点的next指针
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
}
