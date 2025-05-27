from Node import Node
from collections import deque, defaultdict
import heapq

def main():
    root = Node(1)

    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    root.right.left = Node(6)
    root.right.right = Node(7)

    print("Level Order Traversal of binary tree is:")
    print(level_order_traversal(root))

def level_order_traversal(root):
    node_map = defaultdict(list)
    queue = deque([(root, 0, 0)])

    while queue:
        node, row, col = queue.popleft()
        heapq.heappush(node_map[col], (row, node.data))

        if node.left:
            queue.append((node.left, row + 1, col - 1))
        if node.right:
            queue.append((node.right, row + 1, col + 1))

    result = []
    for col in sorted(node_map.keys()):
        col_nodes = [data for row, data in sorted(node_map[col])]
        result.append(col_nodes)

    return result

if __name__ == "__main__":
    main()
