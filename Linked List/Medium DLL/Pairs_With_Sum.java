import java.util.HashMap;
import java.util.Map;

public class Pairs_With_Sum{
    public static void main(String[] args){
        Doubly_Linked_List dll = new Doubly_Linked_List();

        dll.insert(1);
        dll.insert(2);
        dll.insert(3);
        dll.insert(4);
        dll.insert(9);

        int sum = 5;
        Node left = dll.head;
        Node right = findTail(dll.head);

        HashMap <Integer, Integer> hm = new HashMap<>();

        while (left.data < right.data) { 
            if (left.data + right.data == sum) {
                hm.put(left.data, right.data);
                left = left.next;
                right = right.prev;
            }
            else if (left.data + right.data < sum) {
                left = left.next;
            }
            else{
                right = right.prev;
            }
        }

        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            System.out.println("(" + entry.getKey() + "," + entry.getValue() + ")");
        }
    }

    private static Node findTail(Node head){
        Node tail = head;

        while (tail.next != null) { 
            tail = tail.next;
        }
        return tail;
    }
}