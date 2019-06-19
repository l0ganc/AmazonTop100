package Day3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC449SerializeandDeserializeBST {
    /**
     * similar to 297
     * but 449 is a bst, we can use this to build our tree
     */

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    public void buildString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val).append(",");
        buildString(root.left, sb);
        buildString(root.right, sb);

    }

    // Encodes a tree to a single string.
    public TreeNode derialize(String data) {
        Queue<String> queue = new LinkedList<>();
        String[] res = data.split(",");
        queue.addAll(Arrays.asList(res));

        return buildTree(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode buildTree(Queue<String> queue, int min, int max) {
        if (queue.isEmpty()) return null;

        String cur = queue.peek();
        int val = Integer.parseInt(cur);

        if (val < min || val > max) {
            return null;
        }

        queue.poll();
        TreeNode root = new TreeNode(val);

        root.left = buildTree(queue, min, val);
        root.right = buildTree(queue, val, max);

        return root;

    }


}
