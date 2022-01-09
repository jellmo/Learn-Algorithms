package primary.link;

/**
 * <p>
 * 删除链表中的节点
 * 请编写一个函数，用于 删除单链表中某个特定节点 。在设计函数时需要注意，你无法访问链表的头节点 head ，只能直接访问 要被删除的节点 。
 * 题目数据保证需要删除的节点 不是末尾节点 。
 * </p>
 * <p>
 * 思路：
 * 单链表，由于无法访问头节点，因此我们无法拿到上一个节点，也就无法进行删除操作，故而可以考虑将下一个结点复制到当前结点。
 * 然后对下一个结点进行删除操作，这样是一个流程。（题目数据保证需要删除的节点不是末尾节点，也即被删除结点具有下一结点）
 *
 * @author mohe
 * @date 2022-01-09 21:22:28
 */
public class DeleteNode {

    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}
