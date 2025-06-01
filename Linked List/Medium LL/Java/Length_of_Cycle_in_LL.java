public class Length_of_Cycle_in_LL{
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

        int len = length_of_cycle(list.head);
        System.out.println("Length of the Cycle in Linked List is : " + len);
    }

    private static int length_of_cycle(Node head){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) { 
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                int count = 1;
                Node current = slow.next;

                while(current != slow){
                    count++;
                    current = current.next;
                }
                return count;
            }
        }
        return -1;
    }
}