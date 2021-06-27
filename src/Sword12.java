/**
 * @author whc
 * @Title: Sword12
 * @Package: PACKAGE_NAME
 * @Description: 剑指 Offer 12. 矩阵中的路径
 * @date 2021/6/27 11:18
 *
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 *
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 * A B C E
 * S F C S
 * A D E E
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * board 和 word 仅由大小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *具体图片参考下文链接
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword12 {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != words[k] ) {
            return false;
        }
        if (k == words.length-1) {
            return true;
        }

        board[i][j] = '\0';
        boolean res = dfs(board, words, i+1, j, k+1) || dfs(board, words, i-1, j, k+1) ||
                dfs(board, words, i, j+1, k+1) || dfs(board, words, i, j-1, k+1);

        /**
         * 此处是如何回溯将每个被置为'\0'的位置还原为原字符的呢？
         * 当最后一个字符匹配完成并成功后， 可以看到return true了，那么这个true会顺着res的递归往上回传
         * 由于方法最后return res。因此会以如下顺序执行：
         * 65 -> 74 -> 75 -> 65 -> 74 -> 65....直至回溯到第一层，即可全部还原
         * 此处设计非常巧妙，可以进入debug模式仔细体会
         */
        board[i][j] = words[k];
        return res;
    }


    public static void main(String[] args) {
        char[][] target = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'},{'A', 'D', 'E', 'E'}};
        Sword12 sword12 = new Sword12();
        System.out.println(sword12.exist(target, "ABCCED"));
    }
}
