from Node import Node
from collections import deque, defaultdict
import heapq

def main():
    root = Node(1)

    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    root.right.left = Node(6)
    root.right.right = Node(7)

    print("Level Order Traversal of binary tree is:")
    print(level_order_traversal(root))

# def level_order_traversal(root):
    