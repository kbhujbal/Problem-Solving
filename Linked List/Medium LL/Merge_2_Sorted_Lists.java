

public class Merge_2_Sorted_Lists{
    public static void main(String[] args) {
        Linked_List list1 = new Linked_List();
        Linked_List list2 = new Linked_List();

        list1.insert(1);
        list1.insert(3);
        list1.insert(5);
        list1.insert(7);

        list2.insert(2);
        list2.insert(4);
        list2.insert(6);
        list2.insert(8);

        Node newHead = merge_2_lists(list1.head, list2.head);

        Node curr = newHead;
        while(curr != null){
            if (curr.data == -1) {
                curr = curr.next;
                continue;
            }
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
    }

    private static Node merge_2_lists(Node head1, Node head2){
        Node dummy = new Node(-1);
        Node temp = dummy;
        Node t1 = head1;
        Node t2 = head2;

        while(t1 != null && t2 != null){
            if (t1.data <= t2.data) {
                temp.next = t1;
                t1 = t1.next;
            }
            else{
                temp.next = t2;
                t2 = t2.next;
            }
            temp = temp.next;
        }

        if (t1 != null) temp.next = t1;
        else temp.next = t2;

        return dummy;
    }
}