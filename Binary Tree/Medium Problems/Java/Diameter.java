public class Diameter {
    public static void main(String[] args){
        Node root = new Node(1);

        Node newNode2 = new Node(2);
        Node newNode3 = new Node(3);
        Node newNode4 = new Node(4);
        Node newNode5 = new Node(5);
        Node newNode6 = new Node(6);
        Node newNode7 = new Node(7);
        Node newNode8 = new Node(8);
        Node newNode9 = new Node(9);

        root.left = newNode2;
        root.right = newNode3;
        root.right.left = newNode4;
        root.right.left.left = newNode5;
        root.right.left.left.left = newNode9;
        root.right.right = newNode6;
        root.right.right.right = newNode7;
        root.right.right.right.right = newNode8;

        int dmtr = diameter_of_tree(root);
        System.out.println("Diameter of the Binary Tree is : " + dmtr);
    }

    private static int diameter_of_tree(Node root){
        int [] diameter = new int[1];
        height(root, diameter);
        return diameter[0];
    }

    private static int height(Node node, int [] diameter){
        if(node == null) return 0;

        int lh = height(node.left, diameter);
        int rh = height(node.right, diameter);

        diameter[0] = Math.max(diameter[0], lh + rh);

        return 1 + Math.max(lh, rh);
    }
}


class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}