from Node import Node


def count_nodes(root):
    if not root:
        return 0
    
    def get_height(node, go_left):
        height = 0

        while node:
            height += 1
            node = node.left if go_left else node.right
        
        return height
    
    left_height = get_height(root, True)
    right_height = get_height(root, False)

    if left_height == right_height:
        return (1 << left_height) - 1
    else: 
        return 1 + count_nodes(root.left) + count_nodes(root.right)




if __name__ == "__main__":
    root = Node(1)

    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    root.left.left.left = Node(8)
    root.left.left.right = Node(9)
    root.left.right.left = Node(10)
    root.left.right.right = Node(11)
    root.right.left = Node(6)
    root.right.right = Node(7)

    ans = count_nodes(root)
    print(ans)