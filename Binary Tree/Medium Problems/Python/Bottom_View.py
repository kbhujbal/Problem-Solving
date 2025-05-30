from Node import Node
from collections import deque

def main():
    root = Node(1)

    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    root.left.right.left = Node(8)
    root.left.right.right = Node(9)
    root.right.right = Node(7)
    root.right.left = Node(6)

    ans = Bottom_View(root)
    print(ans)



def Bottom_View(root):
    if not root:
        return []
    
    hd_map = dict()
    queue = deque([(root, 0)])

    min_hd = max_hd = 0

    while queue:
        node, hd = queue.popleft()

        hd_map[hd] = node.data

        min_hd = min(min_hd, hd)
        max_hd = max(max_hd, hd)

        if node.left:
            queue.append((node.left, hd - 1))
        if node.right:
            queue.append((node.right, hd + 1))

    return [hd_map[hd] for hd in range(min_hd, max_hd + 1)]




if __name__ == "__main__":
    main()