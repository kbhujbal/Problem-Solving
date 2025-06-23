from Node import Node
from collections import defaultdict, deque


def min_burn(root, target):
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
    q.append(target)
    visited.add(target)

    time = 0

    while q:
        size = len(q)
        burn_occurred = False

        for _ in range(size):
            curr = q.popleft()

            for neighbor in graph[curr]:
                if neighbor not in visited:
                    visited.add(neighbor)
                    q.append(neighbor)
                    burn_occurred = True
        
        if burn_occurred:
            time += 1

    return time



if __name__ == "__main__":
    root = Node(1)

    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.left.right = Node(7)
    root.right.left = Node(5)
    root.right.right = Node(6)

    ans = min_burn(root, root.left.data)
    print(ans)