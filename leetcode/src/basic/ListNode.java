package basic;

/**
 * <p>
 * 链表实现
 * </p>
 *
 * @author mohe
 * @date 2022-01-09 21:25:24
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int x) {
        this.val = x;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
