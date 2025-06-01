public class Palindrome_LL{
    public static void main(String[] args) {
        Linked_List list = new Linked_List();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(3);
        list.insert(2);
        list.insert(1);

        boolean isPalindrome = check_LL_palindrome(list.head);
        if (isPalindrome) {
            System.out.println("Linked List is a Palindrome");
        }
        else{
            System.out.println("Linked List is not a Palindrome");
        }
    }

    private static boolean check_LL_palindrome(Node head){
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) { 
            slow = slow.next;
            fast = fast.next.next;
        }

        Node new_head = reverse(slow.next);

        Node first = head;
        Node second = new_head;
        while (second != null) { 
            if (first.data != second.data) {
                reverse(new_head);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverse(new_head);

        return true;
    }

    private static Node reverse(Node head){
        Node prev = null;
        Node curr = head;

        while (curr != null) { 
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }
}