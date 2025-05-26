public class Maximum_Path_Sum {
    public static void main(String[] args){
        Node root = new Node(-10);

        Node newNode9 = new Node(9);
        Node newNode20 = new Node(20);
        Node newNode15 = new Node(15);
        Node newNode7 = new Node(7);

        root.left = newNode9;
        root.right = newNode20;
        root.right.left = newNode15;
        root.right.right = newNode7;
        
        int [] maxValue = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        max_path_sum(root, maxValue);

        System.out.println("Maximum Path Sum in the Binary Tree is : " + maxValue[0]);
    }

    private static int max_path_sum(Node node, int[] maxValue){
        if(node == null) return 0;

        int leftSum = Math.max(0, max_path_sum(node.left, maxValue));
        int rightSum = Math.max(0, max_path_sum(node.right, maxValue));

        maxValue[0] = Math.max(maxValue[0] ,node.data + leftSum + rightSum);

        return Math.max(leftSum, rightSum) + node.data;
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