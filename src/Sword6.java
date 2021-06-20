import java.util.Arrays;
import java.util.Stack;

/**
 * @author whc
 * @Title: Sword6
 * @Package: PACKAGE_NAME
 * @Description: 剑指 Offer 06. 从尾到头打印链表
 * @date 2021/6/12 12:34
 *
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class Sword6 {
    public static int[] reversePrint(ListNode head) {
        int i = 0;
        Stack<Integer> stack = new Stack<Integer>();
        ListNode start = head;
        while(start != null) {
            stack.push(start.val);
            start = start.next;
            i++;
        }
        int [] result = new int[i];
        for (int j = 0; j < i; j++) {
            result[j] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
    }
}

class ListNode {

      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
      }
}