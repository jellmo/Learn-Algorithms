package sword;

import basic.TreeNode;

/**
 * <p>
 * 剑指 Offer 28. 对称的二叉树
 * </p>
 * <p>
 * 镜像输出序列实质上是镜像前序遍历（右中左）输出序列
 *
 * @author mohe
 * @date 2022-02-07 12:06:20
 */
public class Symmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        //左右子树都为空，为镜像
        if (left == null && right == null)
            return true;
        //左子树或右子树为空，一定不为镜像
        if (left == null || right == null)
            return false;
        //两节点不相等，肯定不是镜像
        if (left.val != right.val)
            return false;
        //判断左节点的左子树和右节点的右子树是否镜像，以及左节点的右子树和右节点的左子树是否镜像
        return (isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left));
    }
}
