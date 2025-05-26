public class Balanced_Binary_Tree {
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
        root.right = newNode4;
        root.left.left = newNode3;
        root.left.left.left = newNode9;
        root.right.left = newNode5;
        root.right.right = newNode6;
        root.right.right.right = newNode7;
        root.right.right.right.right = newNode8;

        if (balanced(root) != -1) {
            System.out.println("Tree is Height Balanced!");
        }
        else{
            System.out.println("Tree is not a Height Balanced!");
        }
    }

    private static int balanced(Node node){
        if(node == null) return 0;

        int lh = balanced(node.left);
        int rh = balanced(node.right);

        if(lh == -1 || rh == -1) return -1;
        if(Math.abs(lh - rh) > 1) return -1;

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