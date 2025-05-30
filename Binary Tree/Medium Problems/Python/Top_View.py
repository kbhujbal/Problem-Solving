from Node import Node

def main():
    root = Node(1)

    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    root.left.right.left = Node(6)
    root.right.right = Node(7)

    ans = Top_View(root)
    print(ans)

def Top_View(root):
    node = root

if __name__ == "__main__":
    main()