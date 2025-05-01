public class DetectCycle{
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

        boolean hasCycle = hasCycle(list.head);
        System.out.println("Cycle detected? " + hasCycle);
    }

    public static boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}