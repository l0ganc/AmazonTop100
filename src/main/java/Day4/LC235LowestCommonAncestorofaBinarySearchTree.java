package Day4;

public class LC235LowestCommonAncestorofaBinarySearchTree {
    /**
     * 235. Lowest Common Ancestor of a Binary Search Tree
     */


    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }


    // time = O(n); Space = O(1)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;

        while (cur != null) {
            if (p.val > cur.val && q.val > cur.val) {
                cur = cur.right;
            } else if (p.val < cur.val && q.val < cur.val) {
                cur = cur.left;
            } else {
                return cur;
            }
        }

        return null;
    }


    // 递归
    // time = O(n); Space = O(1)
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;

        while (cur != null) {
            if (p.val > cur.val && q.val > cur.val) {
                return lowestCommonAncestor(root.right, p, q);
            } else if (p.val < cur.val && q.val < cur.val) {
                return lowestCommonAncestor(root.left, p, q);
            } else {
                return cur;
            }
        }

        return null;
    }
}
