from Node import Node
import heapq
from collections import defaultdict, deque

def main():
    root = Node(1)

    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    root.right.left = Node(6)
    root.right.right = Node(7)

    ans = verticalOrderTraversal(root)
    print(ans)

def verticalOrderTraversal(root):
    node_map = defaultdict(list)
    queue = deque([(root, 0, 0)])

    while queue:
        node, row, col = queue.popleft()
        heapq.heappush(node_map[col], (row, node.val))

        if node.left:
            queue.append((node.left, row + 1, col - 1))
        if node.right:
            queue.append((node.right, row + 1, col + 1))

    result = []
    for col in sorted(node_map.keys()):
        col_nodes = [val for row, val in sorted(node_map[col])]
        result.append(col_nodes)

    return result
