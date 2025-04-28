public class Doubly_Linked_List{
    public static void main(String[] args) {
        DLL dll = new DLL();

        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);
        dll.insertAtEnd(40);
        dll.insertAtEnd(50);

        System.out.println("Doubly Linked List: ");
        dll.printList();

        System.out.println("After Inserting '0' at the beginning: ");
        dll.insertAtBeginning(0);
        dll.printList();

        System.out.println("After Deleting a '30' node: ");
        dll.deleteNode(30);
        dll.printList();

        System.out.println("After reversing the list: ");
        dll.reverse();
        dll.printList();
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
    public void reverse() {
        Node temp = null;
        Node current = head;

        // Swap next and prev for all nodes
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        // Update head to the last node
        if (temp != null) {
            head = temp.prev;
        }
    }


    // Print the List
    public void printList(){
        Node current = head;
        
        while (current != null) { 
            System.out.print(current.data + " -> ");
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