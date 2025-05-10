public class Stack_Using_LL {
    private Node top; 

    public Stack_Using_LL() {
        top = null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow: Cannot pop from empty stack");
        }
        int poppedData = top.data;
        top = top.next;
        return poppedData;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty: Cannot peek");
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void display() {
        Node temp = top;
        System.out.print("Top -> ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Stack_Using_LL stack = new Stack_Using_LL();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.display();  
        stack.pop();
        stack.display();
        stack.push(50);
        stack.push(60);
        stack.display();  
        stack.pop();
        stack.display();  
    }
}
