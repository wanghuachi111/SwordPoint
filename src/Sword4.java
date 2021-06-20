/**
 * @author whc
 * @Title: Sword4
 * @Package: PACKAGE_NAME
 * @Description: 剑指offer 4
 * @date 2021/6/11 22:43
 */

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *[
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword4 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean result = false;
        int targetColum = m-1;
        int targetRow = 0;

        while ( targetRow < n && targetColum >= 0 ) {
            if (matrix[targetRow][targetColum] > target) {
                targetColum--;
            } else if (matrix[targetRow][targetColum] < target) {
                targetRow++;
            } else {
                result = true;
                break;    //此处必须有个break，否则将等同于全表遍历，一旦找到相等值，直接跳出
            }
        }

        return result;

    }
}
