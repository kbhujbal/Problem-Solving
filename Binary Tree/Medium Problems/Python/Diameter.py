from Node import Node

def main():
    root = Node(1)

    root.left = Node(2)
    root.right = Node(3)
    root.right.left = Node(4)
    root.right.left.left = Node(5)
    root.right.left.left.left = Node(9)
    root.right.right = Node(6)
    root.right.right.right = Node(7)
    root.right.right.right.right = Node(8)

    ans = Diameter(root)
    print("Diameter of the Binary Tree is : " + str(ans))


def Diameter(root):
    diameter = 0

    def dfs(node):
        nonlocal diameter
        if not node:
            return 0
        
        left = dfs(node.left)
        right = dfs(node.right)

        diameter = max(diameter, left + right)

        return 1 + max(left, right)
    
    dfs(root)
    return diameter



if __name__ == "__main__":
    main()