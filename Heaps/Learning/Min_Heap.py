import heapq

# 1. Initialize a heap (just an empty list)
min_heap = []

# 2. Push (add) an item
# The heap property is maintained.
heapq.heappush(min_heap, 10)
heapq.heappush(min_heap, 4)
heapq.heappush(min_heap, 8)
heapq.heappush(min_heap, 1)

# The list might not look sorted, but it maintains the heap structure
# Internal list might look like: [1, 4, 8, 10]
print(f"Min Heap (internal list): {min_heap}")

# 3. Peek (view) the smallest item
# The smallest item is always the first element (the root)
smallest = min_heap[0]
print(f"Smallest item (peek): {smallest}")

# 4. Pop (remove and return) the smallest item
# The smallest item is removed, and the heap is restructured.
smallest_popped = heapq.heappop(min_heap)
print(f"Popped item: {smallest_popped}")
print(f"Heap after pop: {min_heap}")
print(f"New smallest item: {min_heap[0]}")

# 5. Heapify (convert an existing list into a heap)
# This is an efficient O(n) operation.
data = [5, 7, 9, 1, 3, 4]
heapq.heapify(data)
print(f"Heapified list: {data}") # data is now [1, 3, 4, 7, 5, 9]