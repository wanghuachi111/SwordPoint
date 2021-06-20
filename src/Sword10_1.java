/**
 * @author whc
 * @Title: Sword10_1
 * @Package: PACKAGE_NAME
 * @Description: 剑指 Offer 10- I. 斐波那契数列
 * @date 2021/6/20 12:17
 *
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 *
 * F(0) = 0,F(1)= 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword10_1 {


    /**
     *
     * 此方法会出现过多的重复计算，比如fib3、fib4都会计算一遍fib2，这样会导致超时
    public int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return (fib(n-1) + fib(n-2)) % 1000000007 ;
        }
    }
     */

    /**
     *
     * @param n
     * @return a
     * @description: 此处利用a、b的交替前进来规避多余的重复计算，返回a则是因为循环多进行了一次，故而返回了a而不是sum
     */
    public int fib(int n) {
        int a = 0;
        int b = 1;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
            System.out.println(i + ":  a=" + a + " b=" + b + " sum=" + sum);
        }

        return a;
    }

    public static void main(String[] args) {
        Sword10_1 sword10_1 = new Sword10_1();
        System.out.println(sword10_1.fib(5));
    }
}
