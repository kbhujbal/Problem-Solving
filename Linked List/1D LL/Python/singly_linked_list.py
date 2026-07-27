class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class SinglyLinkedList:
    def __init__(self):
        self.head = None

    # 1. Append (Add to the end) - O(n)
    def append(self, data):
        new_node = Node(data)

        if not self.head:
            self.head = new_node
            return

        current = self.head
        while current.next:
            current = current.next
        current.next = new_node

    # 2. Prepend (Add to the beginning) - O(1)
    def prepend(self, data):
        new_node = Node(data)
        new_node.next = self.head
        self.head = new_node

    # 3. Delete a node by value - O(n)
    def delete(self, key):
        current = self.head

        # Case 1: Key is at the head
        if current and current.data == key:
            self.head = current.next
            current = None
            return

        # Case 2: Key is somewhere in the middle or end
        prev = None
        while current and current.data != key:
            prev = current
            current = current.next

        if not current:
            print(f"Value '{key}' not found in list.")
            return

        prev.next = current.next
        current = None

    # 4. Traversal / Printing - O(n)
    def display(self):
        nodes = []
        current = self.head
        while current:
            nodes.append(str(current.data))
            current = current.next
        print(" -> ".join(nodes) if nodes else "Empty List")


ll = SinglyLinkedList()

ll.append(10)
ll.append(20)
ll.append(30)
ll.display()  # Output: 10 -> 20 -> 30

ll.prepend(5)
ll.display()  # Output: 5 -> 10 -> 20 -> 30

ll.delete(20)
ll.display()  # Output: 5 -> 10 -> 30