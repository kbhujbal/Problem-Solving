public class Delete_All_Occurrences{
    public static void main(String[] args) {
        Doubly_Linked_List dll = new Doubly_Linked_List();

        dll.insert(10);
        dll.insert(4);
        dll.insert(10);
        dll.insert(10);
        dll.insert(6);
        dll.insert(10);

        System.out.println("Linked List Before Deletion is :");
        dll.display();

        dll.head = delete_all(dll.head, 10);

        System.out.println("Linked List After Deletion is :");
        dll.display();
    }

    private static Node delete_all(Node head, int num){
        Node temp = head;
        Node prevNode = null;
        Node nextNode = null;

        while (temp != null) { 
            if (temp.data == num) {
                if (temp == head) {
                    head = temp.next;
                }

                nextNode = temp.next;
                prevNode = temp.prev;

                if (nextNode != null) {
                    nextNode.prev = prevNode;
                }

                if (prevNode != null) {
                    prevNode.next = nextNode;
                }

                temp = nextNode;
            }
            else{
                temp = temp.next;
            }
        }
        return head;
    }
}