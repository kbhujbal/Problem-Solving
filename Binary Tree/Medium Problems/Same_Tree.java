public class Same_Tree {
    public static  void main(String[] args){
        // Tree 1
        Node root1 = new Node(1);

        Node newNode21 = new Node(2);
        Node newNode31 = new Node(3);
        Node newNode41 = new Node(4);
        Node newNode51 = new Node(5);

        root1.left = newNode21;
        root1.right = newNode31;
        root1.right.left = newNode41;
        root1.right.right = newNode51;
        
        // Tree 2
        Node root2 = new Node(1);

        Node newNode22 = new Node(2);
        Node newNode32 = new Node(3);
        Node newNode42 = new Node(4);
        Node newNode52 = new Node(5);

        root2.left = newNode22;
        root2.right = newNode32;
        root2.right.left = newNode42;
        root2.right.right = newNode52;

        if (check_same_tree(root1, root2)) {
            System.out.println("Both are Same Trees !");
        }
        else{
            System.out.println("Both Trees are Different !");
        }
    }
    
    private static boolean check_same_tree(Node node1, Node node2){
        if (node1 == null || node2 == null) {
            return (node1 == node2);
        }

        return (node1.data == node2.data) && check_same_tree(node1.left, node2.left) && check_same_tree(node1.right, node2.right);
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