from Node import Node


def LCA(root, p, q):
    if root is None or root == p or root == q:
        return root
    
    left = LCA(root.left, p, q)
    right = LCA(root.right, p, q)

    if left and right:
        return root
    
    return left if left else right


if __name__ == "__main__":
    root = Node(1)

    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    root.left.right.left = Node(6)
    root.left.right.right = Node(7)
    root.right.left = Node(8)
    root.right.right = Node(9)

    p = root.left.left
    q = root.left.right.right

    ans = LCA(root, p, q)
    print(ans.data)