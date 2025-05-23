public class Height_of_Binary_Tree{
    public static void main(String[] args) {
        Node root = new Node(1);

        Node newNode2 = new Node(2);
        Node newNode3 = new Node(3);
        Node newNode4 = new Node(4);
        Node newNode5 = new Node(5);
        Node newNode6 = new Node(6);

        root.left = newNode2;
        root.right = newNode3;
        root.right.left = newNode4;
        root.right.left.left = newNode5;
        root.right.right = newNode6;

        int md = maxDepth(root);
        System.out.println("Height of the Binary Tree is : " + md);
    }

    private static int maxDepth(Node node){
        if (node == null) return 0;

        int lh = maxDepth(node.left);
        int rh = maxDepth(node.right);

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
