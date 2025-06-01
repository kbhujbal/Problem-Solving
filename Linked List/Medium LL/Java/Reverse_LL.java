public class Reverse_LL{
    public static void main(String[] args){
        Linked_List list = new Linked_List();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        System.out.println("Linked List before reversal is : ");
        list.display();

        Node prev = null;
        Node curr = list.head;

        while (curr != null) { 
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        list.head = prev;
        System.out.println("Linked List after reversal is : ");
        list.display();
    }
}