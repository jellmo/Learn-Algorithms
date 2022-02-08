package sword;

import java.util.Stack;

/**
 * <p>
 * 剑指 Offer 30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * </p>
 *
 * @author mohe
 * @date 2022-02-08 23:46:24
 */
public class MinStack {

    Stack<Integer> A;
    Stack<Integer> B;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.add(x);
        if (B.empty() || B.peek() >= x)
            B.add(x);
        else
            B.add(B.peek());
    }

    public void pop() {
        if (!A.empty() && !B.empty()) {
            A.pop();
            B.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
}
