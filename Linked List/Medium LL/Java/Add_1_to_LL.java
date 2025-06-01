public class Add_1_to_LL{
    public static void main(String[] args){
        Linked_List list = new Linked_List();

        list.insert(3);
        list.insert(2);
        list.insert(6);

        list.head = add_1(list.head);

        list.display();
    }

    private static Node add_1(Node head){
        int carry = helper(head);

        if (carry == 1) {
            Node newNode = new Node(1);
            newNode.next = head;
            return newNode;
        }
        return head;
    }

    private static int helper(Node temp){
        if(temp == null) return 1;

        int carry = helper(temp.next);
        temp.data = temp.data + carry;

        if (temp.data < 10) {
            return 0;
        }

        temp.data = 0;
        return 1;
    }
}


// Brute Force Aapproach : 
// In this approach we are using multiple passes, we first reverse, then traverse and then again reverse
// Hence this approach is not optimal


// public class Add_1_to_LL{
//     public static void main(String[] args){
//         Linked_List list = new Linked_List();

//         list.insert(9);
//         list.insert(9);
//         list.insert(9);

//         Node newNode = add_1(list.head);
//         System.out.println("After Adding 1 : ");

//         Node curr = newNode;

//         while (curr != null) { 
//             System.out.print(curr.data);
//             curr = curr.next;
//         }
//     }

//     private static Node add_1(Node head){
//         head = reverse(head);
//         Node temp = head;
//         int carry = 1;

//         while (temp != null) { 
//             temp.data = temp.data + carry;

//             if (temp.data < 10) {
//                 carry = 0;
//                 break;
//             }
//             else{
//                 temp.data = 0;
//                 carry = 1;
//             }
//             temp = temp.next;
//         }

//         if (carry == 1) {
//             Node newNode = new Node(1);
//             head = reverse(head);
//             newNode.next = head;
//             return newNode;
//         }
//         head = reverse(head);
//         return head;
//     }

//     private static Node reverse(Node head){
//         Node prev = null;
//         Node curr = head;

//         while (curr != null) { 
//             Node next = curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = next; 
//         }
        
//         head = prev;
//         return head;
//     }
// }