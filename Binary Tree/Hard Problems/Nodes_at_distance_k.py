from collections import defaultdict, deque
from Node import Node


def distanceK(root, target, k):
    graph = defaultdict(list)

    def build_graph(node, parent = None):
        if node:
            if parent:
                graph[node.data].append(parent.data)
                graph[parent.data].append(node.data)
            build_graph(node.left, node)
            build_graph(node.right, node)

    build_graph(root)

    visited = set()
    q = deque()
    q.append((target.data, 0))
    visited.add(target.data)

    res = []
    while q:
        curr, dist = q.popleft()
        if dist == k:
            res.append(curr)
        elif dist < k:
            for neighbor in graph[curr]:
                if neighbor not in visited:
                    visited.add(neighbor)
                    q.append((neighbor, dist + 1))
    
    return res
    
    


if __name__ == "__main__":
    root = Node(3)

    root.left = Node(5)
    root.right = Node(1)
    root.left.left = Node(6)
    root.left.right = Node(2)
    root.left.right.left = Node(7)
    root.left.right.right = Node(4)
    root.right.left = Node(0)
    root.right.right = Node(8)

    ans = distanceK(root, root.left, 2)
    print(ans)