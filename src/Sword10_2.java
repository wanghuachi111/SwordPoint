/**
 * @author whc
 * @Title: Sword10_2
 * @Package: PACKAGE_NAME
 * @Description: 剑指 Offer 10- II. 青蛙跳台阶问题
 * @date 2021/6/20 14:20
 *
 *一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 *
 * 输入：n = 0
 * 输出：1
 * 提示：
 *
 * 0 <= n <= 100
 *
 *
 * 思路与上题一样，不同的是，青蛙最后一步只可能是1或者2，因此f(n) = f(n-1) + f(n-2)
 * 但是此题中f(0)=1(题中规定的) f(1)=1, f(2)=2
 */
public class Sword10_2 {

    public int numWays(int n) {
        int a = 1, b =1, sum;
        for (int i = 0 ; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    public static void main(String[] args) {
        Sword10_2 sword10_2 = new Sword10_2();
        System.out.println(sword10_2.numWays(7));
    }

}
