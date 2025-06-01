public class Deleting_Middle_Node{
    public static void main(String[] args) {
        Linked_List list = new Linked_List();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(7);

        System.out.println("Linked List before deleting the middle node is : ");
        list.display();

        list.head = delete_middle_node(list.head);

        System.out.println("Linked List after deleting middle node is : ");
        list.display();
    }

    private static Node delete_middle_node(Node head){
        Node slow = head;
        Node fast = head.next.next;

        while (fast != null && fast.next != null) { 
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}