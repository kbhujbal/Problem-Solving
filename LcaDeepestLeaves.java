import java.util.*;

public class LcaDeepestLeaves {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
        }
    }

    static class Pair {
        int depth;
        TreeNode node;
        Pair(int depth, TreeNode node) {
            this.depth = depth;
            this.node = node;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).node;
    }

    private Pair dfs(TreeNode root) {
        if (root == null) return new Pair(0, null);
        Pair left = dfs(root.left);
        Pair right = dfs(root.right);
        if (left.depth > right.depth) {
            return new Pair(left.depth + 1, left.node);
        } else if (right.depth > left.depth) {
            return new Pair(right.depth + 1, right.node);
        } else {
            return new Pair(left.depth + 1, root);
        }
    }

    public static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0) return null;
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (i < arr.length) {
            TreeNode curr = queue.poll();
            if (arr[i] != null) {
                curr.left = new TreeNode(arr[i]);
                queue.offer(curr.left);
            }
            i++;
            if (i < arr.length && arr[i] != null) {
                curr.right = new TreeNode(arr[i]);
                queue.offer(curr.right);
            }
            i++;
        }
        return root;
    }

    public static void printTree(TreeNode root) {
        if (root == null) return;
        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }

    public static void main(String[] args) {
        Integer[] input = {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = buildTree(input);

        LcaDeepestLeaves solution = new LcaDeepestLeaves();
        TreeNode lca = solution.lcaDeepestLeaves(root);

        System.out.println("Output subtree rooted at: " + lca.val);
        System.out.print("Inorder traversal of output subtree: ");
        printTree(lca);
    }
}
