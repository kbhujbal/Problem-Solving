import java.util.*;

public class Boundary_Traversal {
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
        root.right = newNode3;
        root.left.left = newNode4;
        root.left.right = newNode5;
        root.left.right.left = newNode7;
        root.left.right.right= newNode8;
        root.right.right = newNode6;

        ArrayList<Integer> ans = new ArrayList<>();

        ans = boundary_of_tree(root);

        for (int ele : ans) {
            System.out.print(ele + " ");
        }
    }

    private static ArrayList<Integer> boundary_of_tree(Node root){
        ArrayList<Integer> res = new ArrayList<>();

        if(root == null) return res;

        if(!isLeaf(root)) res.add(root.data);

        // Left Boundary
        Node node = root.left;
        while (node != null) { 
            if(!isLeaf(node)) res.add(node.data);

            if(node.left != null) node = node.left;
            else node = node.right;
        }

        // Add Leaf Nodes
        addLeaves(root, res);
        
        // Right Boundary
        Stack<Integer> stack = new Stack<>();
        node = root.right;
        while (node != null) { 
            if(!isLeaf(node)) stack.push(node.data);

            if(node.right != null) node = node.right;
            else node = node.left;
        }
        while (!stack.isEmpty()) { 
            res.add(stack.pop());
        }

        return res;
    }

    private static boolean isLeaf(Node node){
        return (node.left == null) && (node.right == null);
    }

    private static void addLeaves(Node node, ArrayList<Integer> res){
        if (isLeaf(node)) {
            res.add(node.data);
            return;
        }

        if(node.left != null) addLeaves(node.left, res);
        if(node.right != null) addLeaves(node.right, res);
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