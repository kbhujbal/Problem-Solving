

public class Remove_Nth_Node_From_End{
    public static void main(String[] args) {
        Linked_List list = new Linked_List();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        int n = 2;

        System.out.println("Linked List before deleting the node is : ");
        list.display();

        list.head = remove_nth_node(list.head, n);
        
        System.out.println("Linked List after deleting the node is : ");
        list.display();
    }

    private static Node remove_nth_node(Node head, int n){
        Node fast = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            head = head.next;
            return head;
        }

        Node slow = head;

        while (fast.next != null) { 
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}







// Brute Force Approach
// public class Remove_Nth_Node_From_End{
//     public static void main(String[] args) {
//         Linked_List list = new Linked_List();

//         list.insert(1);
//         list.insert(2);
//         list.insert(3);
//         list.insert(4);
//         list.insert(5);

//         System.out.println("Linked List before deleting the node is :");
//         list.display();

//         int n = 2;
//         Node temp = list.head;
//         int len = 0;
//         while (temp != null) { 
//             len++;
//             temp = temp.next;
//         }

//         int cnt = len - n;
//         Node temp1 = list.head;

//         while (temp1 != null) { 
//             cnt--;
//             if (cnt == 0) {
//                 break;
//             }
//             temp1 = temp1.next;
//         }

//         temp1.next = temp1.next.next;

//         System.out.println("Linked List after deleting the node is :");
//         list.display();
//     }
// }