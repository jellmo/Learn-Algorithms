package sword;

import basic.ListNode;

import java.util.Stack;

/**
 * <p>
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * </p>
 * <p>
 * 思路：
 * 1. 反转链表，然后输出(破坏原链表结构)
 * 2. 由于遍历只能从头到尾，而输出要求从尾到头，这是典型的后进先出结构，于是可以利用栈，
 * 而递归本身也是一种栈结构，于是递归解法也可以。
 *
 * @author mohe
 * @date 2022-01-20 11:54:02
 */
public class ReversePrint {

    /**
     * 反转链表输出
     *
     * @param head
     * @return
     */
    public int[] reversePrintOne(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode next = new ListNode();
        ListNode node = head;
        int length = 0;
        while (node != null) {
            length++;
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        //反转结束，输出
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = pre.val;
            pre = pre.next;
        }
        return result;
    }

    /**
     * 栈
     *
     * @param head
     * @return
     */
    public int[] reversePrintTwo(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        //输出栈
        Stack<Integer> stack = new Stack<>();
        ListNode node = head;
        int length = 0;
        while (node != null) {
            int value = node.val;
            stack.add(value);
            length++;
            node = node.next;
        }
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = stack.pop();
        }
        return arr;
    }
}
