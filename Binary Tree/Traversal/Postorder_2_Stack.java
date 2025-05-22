import java.util.*;

public class Postorder_2_Stack{
    public static void main(String[] args) {
        Node root = new Node(1);

        Node newNode2 = new Node(2);
        Node newNode3 = new Node(3);
        Node newNode4 = new Node(4);
        Node newNode5 = new Node(5);
        Node newNode6 = new Node(6);
        Node newNode7 = new Node(7);
        Node newNode8 = new Node(8);


        root.left = newNode2;
        root.right = newNode3;
        root.left.left = newNode4;
        root.left.right = newNode5;
        root.right.left = newNode6;
        root.right.left.right = newNode7;
        root.right.left.right.right = newNode8;

        List<Integer> postorder = itr_postorder(root);

        for (int val : postorder) {
            System.out.print(val + " ");
        }
    }

    private static List<Integer> itr_postorder(Node root){
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        ArrayList<Integer> postorder = new ArrayList<>();

        if (root == null) {
            return postorder;
        }

        stack1.push(root);

        while (!stack1.isEmpty()) { 
            root = stack1.pop();
            stack2.add(root);

            if(root.left != null) stack1.push(root.left);
            if(root.right != null) stack1.push(root.right);
        }

        while (!stack2.isEmpty()) { 
            postorder.add(stack2.pop().data);
        }
        return postorder;
    }
}