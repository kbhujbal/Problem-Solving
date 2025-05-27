from Node import Node
from collections import deque

def main():
    root = Node(1)

    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    root.right.left = Node(6)
    root.right.right = Node(7)

    levels = level_order(root)

    print("Level Order Traversal:")
    for level in levels:
        print(level)

def level_order(root):
    if not root:
        return []

    result = []
    queue = deque([root])

    while queue:
        level_size = len(queue)
        level = []

        for _ in range(level_size):
            current = queue.popleft()
            level.append(current.data)

            if current.left:
                queue.append(current.left)
            if current.right:
                queue.append(current.right)

        result.append(level)

    return result    

if __name__ == "__main__":
    main()