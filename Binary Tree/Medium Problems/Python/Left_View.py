from Node import Node

def main():
    root = Node(1)

    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    root.left.right.left = Node(6)
    root.right.right = Node(7)

    ans = Left_View(root)
    print(ans)



def Left_View(root):
    if not root:
        return []
    
    res = []
    
    def dfs(node, depth):
        if not node:
            return
        
        if depth == len(res):
            res.append(node.data)

        dfs(node.left, depth + 1)
        dfs(node.right, depth + 1)

    dfs(root, 0)
    return res



if __name__ == "__main__":
    main()