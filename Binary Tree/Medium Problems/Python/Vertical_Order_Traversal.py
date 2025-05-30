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
#     node_map = defaultdict(list)
#     queue = deque([(root, 0, 0)])

#     while queue:
#         node, row, col = queue.popleft()
#         heapq.heappush(node_map[col], (row, node.data))

#         if node.left:
#             queue.append((node.left, row + 1, col - 1))
#         if node.right:
#             queue.append((node.right, row + 1, col + 1))

#     result = []
#     for col in sorted(node_map.keys()):
#         col_nodes = [data for row, data in sorted(node_map[col])]
#         result.append(col_nodes)

#     return result
    if not root:
        return []

    col_table = defaultdict(list)  # hd -> list of node values
    queue = deque([(root, 0)])     # (node, horizontal_distance)

    min_hd = max_hd = 0

    while queue:
        node, hd = queue.popleft()

        col_table[hd].append(node.data)
        min_hd = min(min_hd, hd)
        max_hd = max(max_hd, hd)

        if node.left:
            queue.append((node.left, hd - 1))
        if node.right:
            queue.append((node.right, hd + 1))

    # Output from leftmost hd to rightmost hd
    return [col_table[hd] for hd in range(min_hd, max_hd + 1)]



if __name__ == "__main__":
    main()

