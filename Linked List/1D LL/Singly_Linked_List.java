public class Singly_Linked_List{
    public static void main(String[] args){
        Linked_List list = new Linked_List();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        System.out.println("Original List:");
        list.display();

        list.delete(3);
        System.out.println("After Deleting 3:");
        list.display();

        list.insertAtBeginning(0);
        System.out.println("After Inserting 0 at Beginning:");
        list.display();
    }
}

class Linked_List{
    Node head;
    // Insert new node at the end
    public void insert(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) { 
            current = current.next;
        }

        current.next = newNode;
    }

    //Insert at the beginning
    public void insertAtBeginning(int data){
        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;       
    }

    // Delete a Node
    public void delete(int data){
        if(head == null) return;

        if(head.data == data){
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null) { 
            if(current.next.data == data){
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    // Search for a value
    public boolean search(int data){
        Node current = head;

        while (current != null) { 
            if(current.data == data) return true;
            current = current.next;
        }
        return false;
    }

    // Display the Linked List
    public void display(){
        Node current = head;

        while (current != null) { 
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}