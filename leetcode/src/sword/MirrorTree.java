package sword;

import basic.TreeNode;

/**
 * <p>
 * 剑指 Offer 27. 二叉树的镜像
 * </p>
 *
 * @author mohe
 * @date 2022-02-07 11:51:10
 */
public class MirrorTree {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        //叶子节点，就无需交换了。
        if (root.left == null && root.right == null)
            return root;
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
