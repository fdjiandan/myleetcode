package leetcode226;

/**
 * @ClassName InvertTree
 * @Description TODO
 * @Author heyantao
 * @Date 2020-09-17 17:46
 * @Version 1.0
 **/
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left= right;
        return root;
    }
}