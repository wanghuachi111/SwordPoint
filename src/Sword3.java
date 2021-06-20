/**
 * @author whc
 * @Title: Sword3
 * @Package: PACKAGE_NAME
 * @Description: 剑指offer  3
 * @date 2021/6/11 22:11
 */

import java.util.HashMap;
import java.util.HashSet;

/**
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 *
 */
public class Sword3 {

    public int findRepeatNumber(int [] nums){

        int length = nums.length;
        int result = 0;

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < length; i++) {
            if (set.contains(nums[i])) {
                System.out.println(nums[i]);
                result = nums[i];
                break;
            } else {
                set.add(nums[i]);
            }
        }
        return result;
    }
}
