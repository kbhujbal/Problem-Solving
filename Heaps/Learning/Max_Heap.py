import heapq

# 1. Initialize a max heap (just an empty list)
max_heap = []

# 2. Push (add) an item
# --- Store the negative of the value ---
heapq.heappush(max_heap, -10) # Store 10 as -10
heapq.heappush(max_heap, -4)  # Store 4 as -4
heapq.heappush(max_heap, -8)  # Store 8 as -8
heapq.heappush(max_heap, -1)  # Store 1 as -1

# Internal list might look like: [-10, -4, -8, -1]
print(f"Max Heap (internal list): {max_heap}")

# 3. Peek (view) the largest item
# --- Access heap[0] and negate it back ---
largest = -max_heap[0]
print(f"Largest item (peek): {largest}")

# 4. Pop (remove and return) the largest item
# --- Pop the item and negate it back ---
largest_popped = -heapq.heappop(max_heap)
print(f"Popped item: {largest_popped}")
print(f"Heap after pop: {max_heap}")
print(f"New largest item: {-max_heap[0]}")

# 5. Heapify an existing list into a max heap
data = [5, 7, 9, 1, 3, 4]
# Create a new list with negative values
max_data = [-x for x in data]
heapq.heapify(max_data)

print(f"Heapified max-heap (internal): {max_data}")
# To get the largest, just look at -max_data[0]
print(f"Largest in heapified list: {-max_data[0]}")