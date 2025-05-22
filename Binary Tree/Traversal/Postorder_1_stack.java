import java.util.*;

public class Postorder_1_stack{
    public static void main(String[] args){
        Node root = new Node(1);

        Node newNode2 = new Node(2);
        Node newNode3 = new Node(3);
        Node newNode4 = new Node(4);
        Node newNode5 = new Node(5);
        Node newNode6 = new Node(6);
        Node newNode7 = new Node(7);
        Node newNode8 = new Node(8);


        root.left = newNode2;
        root.left.left = newNode3;
        root.left.left.right = newNode4;
        root.left.left.right.right = newNode5;
        root.left.left.right.right.right = newNode6;
        root.right = newNode7;
        root.right.left = newNode8;

        List<Integer> postorder = postorder_1(root);
        for (int val : postorder) {
            System.out.print(val + " ");
        }
    }

    private static List<Integer> postorder_1(Node root){
        Stack<Node> stack = new Stack<>();
        ArrayList<Integer> postorder = new ArrayList<>();
        Node curr = root;

        while (curr != null || !stack.isEmpty()) { 
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            else{
                Node temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.peek();
                    stack.pop();
                    postorder.add(temp.data);

                    while (!stack.isEmpty() && temp == stack.peek().right) { 
                        temp = stack.peek();
                        stack.pop();
                        postorder.add(temp.data);
                    }
                }
                else{
                    curr = temp;
                }
            }
        }
        return postorder;
    }
}