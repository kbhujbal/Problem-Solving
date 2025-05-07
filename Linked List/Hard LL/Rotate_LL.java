public class Rotate_LL{
    public static void main(String[] args){
        Linked_List list = new Linked_List();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        
        System.out.println("Linked List Before Rotation is : ");
        list.display();
        list.head = rotate_ll(list.head, 2);
        System.out.println("Linked List After Rotation is : ");
        list.display();
    }

    private static Node rotate_ll(Node head, int k){
        Node tail = head;
        int len = 1;

        while (tail.next != null) { 
            tail = tail.next;
            len++;
        }
        if (k % len == 0) return head;

        tail.next = head;

        k = k % len;

        Node newLastNode = getNewLast(head, len - k);

        head = newLastNode.next;
        newLastNode.next = null;

        return head;
    }

    private static Node getNewLast(Node temp, int ind){
        while (ind > 1) { 
            temp = temp.next;
            ind--;
        }
        return temp;
    }
}