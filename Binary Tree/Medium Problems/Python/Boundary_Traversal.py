from Node import Node

def main():
    root = Node(1)

    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    root.left.right.left = Node(7)
    root.left.right.right = Node(8)
    root.right.right = Node(6)

    ans = Boundary_Traversal(root)
    print(ans)


def Boundary_Traversal(root):
    if not root:
        return []
    
    res = []

    if not isLeaf(root):
        res.append(root.data)

    # Left Boundary
    node = root.left
    while node:
        if not isLeaf(node):
            res.append(node.data)
        
        if node.left:
            node = node.left
        else:
            node = node.right
    
    # Add Leaf Nodes
    addLeaves(root, res)

    # Right Boundary
    stack = []
    node = root.right
    while node:
        if not isLeaf(node):
            stack.append(node.data)

        if node.right:
            node = node.right
        else:
            node = node.left
    while stack:
        res.append(stack.pop())
    
    return res


def isLeaf(node):
    return not node.left and not node.right

def addLeaves(node, res):
    if(isLeaf(node)):
        res.append(node.data)
        return
    
    if node.left:
        addLeaves(node.left, res)
    
    if node.right:
        addLeaves(node.right, res)

if __name__ == "__main__":
    main()