public class Starting_Point_of_Cycle_in_LL{
    public static void main(String[] args) {
        Linked_List list = new Linked_List();

        for (int i = 1; i <= 9; i++) {
            list.insert(i);
        }

        Node temp = list.head;
        Node cycleStart = null;
        Node lastNode = null;

        while (temp != null) { 
            if (temp.data == 3) {
                cycleStart = temp;
            }
            if (temp.next == null) {
                lastNode = temp;
            }
            temp = temp.next;
        }

        if (lastNode != null && cycleStart != null) {
            lastNode.next = cycleStart;
        }

        int st_pt = starting_point(list.head);
        System.out.println("Starting point of the loop in Linked List is : " + st_pt);
    }

    private static int starting_point(Node head){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) { 
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;
                while (slow != fast) { 
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow.data;
            }
        }
        return -1;
    }
}