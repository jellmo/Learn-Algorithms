package sword;

import basic.TreeNode;

import java.util.HashMap;

/**
 * <p>
 * 剑指 Offer 07. 重建二叉树       (难度: medium)
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * </p>
 * <p>
 * 思路：
 * 根据建立二叉树的方式方法，采用递归。
 *
 * @author mohe
 * @date 2022-01-21 10:58:53
 */
public class BuildTree {

    /**
     * 用一个hash表来记录索引位置
     */
    private HashMap<Integer, Integer> indexMap;

    /**
     * 调用函数
     *
     * @param preorder 前序遍历
     * @param inorder  中序遍历
     * @return 根节点
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        int n = preorder.length;
        indexMap = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }

        return recursion(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    /**
     * 递归调用函数，这里的参数选取借鉴C++的指针思想，即不用重复的建立子数组，而是采用下标的方式取子数组
     *
     * @param preorder      前序遍历
     * @param inorder       中序遍历
     * @param preorderLeft  前序遍历左边界
     * @param preorderRight 前序遍历右边界
     * @param inorderLeft   中序遍历左边界
     * @param inorderRight  中序遍历右边界
     * @return 根节点
     */
    public TreeNode recursion(int[] preorder, int[] inorder,
                              int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        //先序遍历为空了，即结束递归，返回null值给叶子结点连接
        if (preorderLeft > preorderRight) {
            return null;
        }

        //前序遍历首元素肯定是根节点，建立根节点
        int rootValue = preorder[preorderLeft];
        TreeNode root = new TreeNode(rootValue);

        //找到中序遍历中根节点的位置，从而分出左右子树
        int inorderRoot = indexMap.get(rootValue);
        int leftSubtree = inorderRoot - inorderLeft;
        /*
         * 中序遍历中，根节点的位置-左边界位置就是左子树的元素个数n，也是左子树的中序遍历，
         * 于是前序遍历中从根节点之后的n个元素即为左子树的前序遍历结果。
         */
        root.left = recursion(preorder, inorder, preorderLeft + 1, preorderLeft + leftSubtree,
                inorderLeft, inorderRoot - 1);
        /*
            中序遍历中，根节点+1到右边界是右子树的中序遍历，前序遍历中，
            左边界+1+左子树节点数目 开始到 右边界是右子树前序遍历
         */
        root.right = recursion(preorder, inorder, preorderLeft + 1 + leftSubtree, preorderRight,
                inorderRoot + 1, inorderRight);
        return root;
    }
}
