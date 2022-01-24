package sword;

import java.util.Stack;

/**
 * <p>
 * 剑指 Offer 09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * </p>
 * <p>
 * 思路：
 * 利用栈后进先出的特点，一个只管进，一个只管出。
 *
 * @author mohe
 * @date 2022-01-24 10:07:23
 */
public class CQueue {

    Stack<Integer> stackOne;
    Stack<Integer> stackTwo;

    public CQueue() {
        stackOne = new Stack<>();
        stackTwo = new Stack<>();
    }

    public void appendTail(int value) {
        stackOne.push(value);
    }

    public int deleteHead() {
        if (stackTwo.size() <= 0) {
            while (stackOne.size() > 0) {
                Integer item = stackOne.pop();
                stackTwo.push(item);
            }
        }
        if (stackTwo.size() == 0) {
            return -1;
        }
        return stackTwo.pop();
    }
}
