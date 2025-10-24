def is_min_heap(arr):
    n = len(arr)
    
    # An empty list or a list with one element is always a heap.
    if n <= 1:
        return True
        
    # We only need to check the parent nodes.
    # The last parent node is at index (n - 2) // 2.
    # We loop from the root (0) up to and including that last parent.
    for i in range((n - 2) // 2 + 1):
        
        # Calculate indices for left and right children
        left_child_index = 2 * i + 1
        right_child_index = 2 * i + 2

        # 1. Check if left child exists and violates the heap property
        #    (Parent is greater than left child)
        if (left_child_index < n and 
            arr[i] > arr[left_child_index]):
            return False
            
        # 2. Check if right child exists and violates the heap property
        #    (Parent is greater than right child)
        if (right_child_index < n and 
            arr[i] > arr[right_child_index]):
            return False
            
    # If we get through the whole loop without finding a violation, it's a valid heap.
    return True

# --- Examples ---

# Valid min heap
heap1 = [1, 3, 2, 5, 7, 6, 4]
# ]
print(f"Is {heap1} a min heap? {is_min_heap(heap1)}")

# Valid min heap (a sorted list is also a valid min heap)
heap2 = [1, 2, 3, 4, 5, 6, 7]
print(f"Is {heap2} a min heap? {is_min_heap(heap2)}")

# Invalid min heap (root 10 is > child 3)
heap3 = [10, 3, 5, 8, 4]
print(f"Is {heap3} a min heap? {is_min_heap(heap3)}")