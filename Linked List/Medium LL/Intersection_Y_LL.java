public class Intersection_Y_LL{
    public static void main(String[] args) {
        // Start - Code for creating example Linked List
        Node intersection = new Node(8);
        intersection.next = new Node(4);
        intersection.next.next = new Node(5);

        Linked_List listA = new Linked_List();
        listA.insert(4);
        listA.insert(1);

        Linked_List listB = new Linked_List();
        listB.insert(5);
        listB.insert(6);
        listB.insert(1);

        Node tempA = listA.head;
        while (tempA.next != null) { 
            tempA = tempA.next;
        }
        tempA.next = intersection;

        Node tempB = listB.head;
        while (tempB.next != null) { 
            tempB = tempB.next;
        }
        tempB.next = intersection;
        // End - Code for creating example Linked List

        Node intersectionNode = find_intersection(listA.head, listB.head);
        System.out.println("The Intersection Point is " + intersectionNode.data);
    }

    private static Node find_intersection(Node head1, Node head2){
        if (head1 == null || head2 == null) return null; 

        Node t1 = head1, t2 = head2;

        while (t1 != t2) { 
            t1 = t1.next;
            t2 = t2.next;

            if(t1 == t2) return t1;

            if(t1  == null) t1 = head2;
            if(t2 == null) t2 = head1;
        }
        return t1;
    }
}