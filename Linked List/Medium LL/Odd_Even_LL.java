public class Odd_Even_LL{
    public static void main(String[] args) {
        Linked_List list = new Linked_List();

        list.insert(1);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(2);
        list.insert(6);

        odd_even_LL(list.head);
        list.display();
    }

    private static Node odd_even_LL(Node head){
        if(head == null || head.next == null) return head;

        Node odd = head;
        Node even = head.next;
        Node evenHead = head.next;

        while (even != null && even.next != null) { 
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even =even.next;
        }
        odd.next = evenHead;

        return head;
    }
}