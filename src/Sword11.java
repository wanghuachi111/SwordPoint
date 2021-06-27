

/**
 * @author whc
 * @Title: Sword11
 * @Package: PACKAGE_NAME
 * @Description: 剑指 Offer 11. 旋转数组的最小数字
 * @date 2021/6/23 23:23
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 */
public class Sword11 {

    public int minArray(int[] numbers) {
        return findMin(0, numbers.length - 1, numbers);
    }

    public int findMin(int low, int high, int[] nums) {

        int pivot = (low + high) / 2;

        if (pivot == low || pivot == high) {
            return nums[low] > nums[high] ? nums[high] : nums[low];
        }

        if (nums[pivot] < nums[high]) {
            return findMin(0, pivot, nums);
        } else if (nums[pivot] > nums[high]) {
            return findMin(pivot, high, nums);
        } else {
            return findMin(low, high-1, nums);
        }
    }

    public static void main(String[] args) {
        Sword11 sword11 = new Sword11();
        int[] target1 = new int[] {5,1,2,3,4};
        int[] target2 = new int[] {1,2,3,4,5};
        int[] target3 = new int[] {4,5,1,2,3};
        System.out.println(sword11.minArray(target1));
        System.out.println(sword11.minArray(target2));
        System.out.println(sword11.minArray(target3));
    }
}
