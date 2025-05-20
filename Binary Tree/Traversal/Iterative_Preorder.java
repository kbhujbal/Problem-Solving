import java.util.*;

public class Iterative_Preorder{
    public static void main(String[] args) {
        Node root = new Node(1);

        Node newNode2 = new Node(2);
        Node newNode3 = new Node(3);
        Node newNode4 = new Node(4);
        Node newNode5 = new Node(5);
        Node newNode6 = new Node(6);
        Node newNode7 = new Node(7);
        Node newNode8 = new Node(8);
        Node newNode9 = new Node(9);
        Node newNode10 = new Node(10);

        root.left = newNode2;
        root.right = newNode3;
        root.left.left = newNode4;
        root.left.right = newNode5;
        root.left.right.left = newNode6;
        root.right.left = newNode7;
        root.right.right = newNode8;
        root.right.right.left = newNode9;
        root.right.right.right = newNode10;

        List<Integer> preorder = preorder_itr(root);

        for (int val : preorder) {
            System.out.print(val + " ");
        }
    }

    private static List<Integer> preorder_itr(Node root){
        Stack<Node> stack = new Stack<>();
        ArrayList<Integer> preorder = new ArrayList<>();

        stack.push(root);

        if (root == null) {
            return preorder;
        }

        while (!stack.isEmpty()) { 
            root = stack.pop();
            preorder.add(root.data);

            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return preorder;
    }
}