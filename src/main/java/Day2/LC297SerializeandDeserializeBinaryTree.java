package Day2;

public class LC297SerializeandDeserializeBinaryTree {
    /**
     * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
     *
     * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
     *
     * Example:
     *
     * You may serialize the following tree:
     *
     *     1
     *    / \
     *   2   3
     *      / \
     *     4   5
     *
     * as "[1,2,3,null,null,4,5]"
     * Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
     *
     * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
     *
     * time = O(n)
     * space = O(n)
     */

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    private static int index;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        buildString(root, sb);

        return sb.toString();
    }
    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("*").append(",");
        } else {
            sb.append(node.val).append(",");
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        index = 0;

        String[] res = data.split(",");
        return buildTree(res);
    }

    private TreeNode buildTree(String[] res) {
        String p = res[index++];
        if (p.equals("*")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(p));
        root.left = buildTree(res);
        root.right = buildTree(res);

        return root;
    }




}
