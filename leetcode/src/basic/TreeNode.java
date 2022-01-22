package basic;

/**
 * <p>
 * 二叉树实现
 * </p>
 *
 * @author mohe
 * @date 2022-01-21 10:55:36
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
    }
}
