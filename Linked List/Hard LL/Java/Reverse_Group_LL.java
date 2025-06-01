public class Reverse_Group_LL{
    public static void main(String[] args) {
        Linked_List list = new Linked_List();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(7);
        list.insert(8);
        list.insert(9);
        list.insert(10);

        System.out.println("Linked List Before Reveral is : ");
        list.display();
        list.head = reverse_in_group(list.head, 3);
        System.out.println("Linked List After Removal is : ");
        list.display();
    }

    private static Node reverse_in_group(Node head, int k){
        Node temp = head;
        Node prevNode = null;
        Node nextNode;
        Node newHead = null;

        while (temp != null) { 
            Node kthNode = getKthNode(temp, k);

            if (kthNode == null) {
                if (prevNode != null) {
                    prevNode.next = temp;
                }
                break;
            }

            nextNode = kthNode.next;
            kthNode.next = null;

            Node reversedHead = reverse(temp);

            if (newHead == null) {
                newHead = reversedHead;
            }

            if (prevNode != null) {
                prevNode.next = reversedHead;
            }

            prevNode = temp;
            temp = nextNode;
        }

        return newHead == null ? head : newHead;
    }

    private static Node getKthNode(Node node, int k){
        while (node != null && k > 1) { 
            node = node.next;
            k--;
        }
        return node;
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

        return prev;
    }
}