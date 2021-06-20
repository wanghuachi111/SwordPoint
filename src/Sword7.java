import java.util.HashMap;
import java.util.Map;

/**
 * @author whc
 * @Title: Sword7
 * @Package: PACKAGE_NAME
 * @Description: 剑指 Offer 07. 重建二叉树
 * @date 2021/6/13 12:17
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword7 {

    private Map<Integer, Integer> indexMap;
    int[] preorder;

    public TreeNode buildTree(int [] preorder, int [] inorder) {
        this.preorder = preorder;

        return null;
    }

    /**
     *
     * @param pre_root_index 根结点在前序遍历中的下标
     * @param in_left_indx 该节点在中序遍历中的左边界
     * @param in_right_index 该节点在中序遍历中的右边界
     * @return
     */
    public TreeNode rebuild(int pre_root_index, int in_left_indx, int in_right_index) {

        if (in_left_indx > in_right_index) {
            return null;
        }

        int in_root_index = indexMap.get(preorder[pre_root_index]);  //获取该节点在中序遍历中的index

        TreeNode node = new TreeNode(preorder[pre_root_index]); //以该节点为根结点开始重建二叉树

        node.left = rebuild(pre_root_index + 1, in_left_indx, in_root_index - 1);
        node.right = rebuild(pre_root_index + in_root_index - in_left_indx + 1, in_root_index + 1, in_right_index);
        return node;
    }

}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}