import java.util.Deque;
import java.util.Stack;

/**
 * @author whc
 * @Title: Sword9
 * @Package: PACKAGE_NAME
 * @Description: 剑指 Offer 09. 用两个栈实现队列
 * @date 2021/6/16 21:48
 *
 * 用两个栈实现一个队列。
 * 队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead操作返回 -1 )
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * /**
 *  * Your CQueue object will be instantiated and called as such:
 *  * CQueue obj = new CQueue();
 *  * obj.appendTail(value);
 *  * int param_2 = obj.deleteHead();
 *
 *
 * here Sword9 = CQueue
 *
 * 思路：栈1负责进，栈2负责出，出栈时，如果栈2为空，那么把栈1的数据全部出栈放到栈2，然后按需求出栈即可，这样每当栈2没东西了，就把栈1的数据倒入栈2，
 * 既保证了队列先进先出的特性，又减少了操作的复杂性
 */

public class Sword9 {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;


    public Sword9() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            if (stack1.isEmpty()) {
                return -1;
            } else {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
        }
        return stack2.pop();
    }
}
