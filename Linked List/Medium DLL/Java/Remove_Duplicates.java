public class Remove_Duplicates{
    public static void main(String[] args) {
        Doubly_Linked_List dll = new Doubly_Linked_List();

        dll.insert(1);
        dll.insert(1); 
        dll.insert(1);
        dll.insert(2);
        dll.insert(3);
        dll.insert(3);
        dll.insert(4);

        System.out.println("Before Removing Duplicates : ");
        dll.display();

        dll.head = remove_duplicates(dll.head);

        System.out.println("After Removing Duplicates : ");
        dll.display();
    }

    private static Node remove_duplicates(Node head){
        if (head == null) {
            return null;
        }

        Node temp = head;

        while (temp != null && temp.next != null) { 
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;

                if (temp.next != null) {
                    temp.next.prev = temp;
                }
            }
            else{
                temp = temp.next;
            }
        }

        return head;
    }
}