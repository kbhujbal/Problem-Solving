public class Doubly_Linked_List{
    public static void main(String[] args) {
        
    }
}

class DLL{
    Node head;

    // Insert new node at the end
    public void insertAtEnd(int data){
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
            return;
        }       

        Node current = head;

        while (current.next != null) { 
            current = current.next;
        }

        current.next = newNode;
        newNode.prev = current;
    }

    // Insert at the beginning
    public void insertAtBeginning(int data){
        Node newNode = new Node(data);

        if (head == null) {
            head =  newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Delete a Node
    public void deleteNode(int key){
        Node current = head;

        // Find the node
        while (current != null && current.data != key) { 
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node not Found");
            return;
        }

        // If node is head
        if (current == head) {
            head = current.next;
            if (head != null) {
                head.prev = null;
            }
        }
        // If node is in middle
        else{
            if (current.next != null) {
                current.next.prev = current.prev;
            }
            if (current.prev != null) {
                current.prev.next = current.next;
            }
        }
    }

    // Reverse the List
    

    // Print the List
    public void printList(){
        Node current = head;
        System.out.println("Doubly Linked List: ");
        while (current != null) { 
            System.out.println(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class Node{
    int data;
    Node next;
    Node prev;

    Node(int data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}