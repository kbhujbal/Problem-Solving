

public class Middle_of_Linked_List{
    public static void main(String[] args){
        Linked_List list = new Linked_List();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        Node middle = findMiddle(list.head);
        System.out.println("Middle node value: " + middle.data);
    }

    public static Node findMiddle(Node head){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) { 
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
