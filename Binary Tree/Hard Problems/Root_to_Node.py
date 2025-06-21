from Node import Node

def getPath(root, target, path):
    if not root:
        return False
    
    path.append(root.data)

    if root.data == target:
        return True
    
    if (getPath(root.left, target, path) or getPath(root.right, target, path)):
        return True
    
    path.pop()
    return False



def Root_2_Node(root, target):
    path = []

    if not root:
        return path
    
    getPath(root, target, path)

    return path


if __name__ == "__main__":
    root = Node(1)

    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    root.left.right.left = Node(6)
    root.left.right.right = Node(7)

    target = 7

    ans = Root_2_Node(root, target)
    print(ans)
