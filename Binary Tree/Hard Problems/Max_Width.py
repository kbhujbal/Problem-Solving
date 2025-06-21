from queue import Queue
from Node import Node


def max_width(root):
    if not root:
        return 0
    
    ans = 0

    q = Queue()
    q.put((root, 0))

    while not q.empty():
        size = q.qsize()
        mmin = q.queue[0][1]
        first, last = None, None

        for i in range(size):
            node, idx = q.get()
            curr_id = idx - mmin

            if i == 0:
                first = curr_id
            
            if i == size - 1:
                last = curr_id
            
            if node.left:
                q.put((node.left, curr_id * 2 + 1))
            
            if node.right:
                q.put((node.right, curr_id * 2 + 2))

        ans = max(ans, last - first + 1)
    
    return ans

    


if __name__ == "__main__":
    root = Node(1)

    root.left = Node(3)
    root.right = Node(2)
    root.left.left = Node(5)
    root.right.right = Node(9)
    root.left.left.left = Node(6)
    root.right.right.left = Node(7)


    ans = max_width(root)
    print(ans)