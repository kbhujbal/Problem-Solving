from Node import Node

def main():
    root = Node(1)

    root.left = Node(2)
    root.left.left = Node(3)
    root.left.right  = Node(4)
    root.right = Node(2)
    root.right.right = Node(3)
    root.right.left = Node(4)

    ans = Symmetric_Tree(root)
    print(ans)


def  Symmetric_Tree(root):
    if not root:
        return True
    
    def isMirror(t1, t2):
        if not t1 and not t2:
            return True
        
        if not t1 or not t2:
            return False
        
        return (t1.data == t2.data and 
                isMirror(t1.left, t2.right) and 
                isMirror(t1.right, t2.left)) 
    
    return isMirror(root.left, root.right)


if __name__ == "__main__":
    main()