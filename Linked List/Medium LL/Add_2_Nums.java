public class Add_2_Nums{
    public static void main(String[] args) {
        Linked_List list1 = new Linked_List();
        list1.insert(3);
        list1.insert(5);

        Linked_List list2 = new Linked_List();
        list2.insert(4);
        list2.insert(5);
        list2.insert(9);
        list2.insert(9);

        Node newHead = add_2(list1.head, list2.head);

        Node curr = newHead;
        
        System.out.println("Addition of 2 Numbers is : ");

        while (curr != null) { 
            System.out.print(curr.data + " - > ");
            curr = curr.next;
        }
    }

    private static Node add_2(Node head1, Node head2){
        Node t1 = head1;
        Node t2 = head2;
        int carry = 0;
        Node dummy = new Node(-1);
        Node curr = dummy;

        while (t1 != null || t2 != null) { 
            int sum = carry;

            if (t1 != null) sum += t1.data; 
            
            if (t2 != null) sum += t2.data; 

            Node newNode = new Node(sum % 10);
            carry = sum / 10;

            curr.next = newNode;
            curr = curr.next;

            if (t1 != null) t1 = t1.next;
    
            if (t2 != null) t2 = t2.next;
        }
        
        if (carry != 0) {
            Node newNode = new Node(carry);
            curr.next = newNode;
        }
        return dummy.next;
    }
}