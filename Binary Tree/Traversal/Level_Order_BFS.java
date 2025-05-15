import java.util.*;

public class Level_Order_BFS{
    public static void main(String[] args) {
        Node root = new Node(1);

        Node newNode2 = new Node(2);
        Node newNode3 = new Node(3);
        Node newNode4 = new Node(4);
        Node newNode5 = new Node(5);
        Node newNode6 = new Node(6);
        Node newNode7 = new Node(7);

        root.left = newNode2;
        root.right = newNode3;
        root.left.left = newNode4;
        root.left.right = newNode5;
        root.right.left = newNode6;
        root.right.right = newNode7;

        List<List<Integer>> levels = level_order(root);

        System.out.println("Level Order Traversal:");
        for (List<Integer> level : levels) {
            System.out.println(level);
        }
    }

    private static List<List<Integer>> level_order(Node node){
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        if (node == null) return result;
        queue.offer(node);

        while (!queue.isEmpty()) { 
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                level.add(current.data);

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right!= null) {
                    queue.offer(current.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}