import heapq

def kth_smallest_element(nums, k):
    """
    Finds the Kth smallest element using a min-heap of size K.
    Time: O(N log K)
    Space: O(K)
    """
    max_heap = []

    for num in nums:
        heapq.heappush(max_heap, -num)

        if len(max_heap) > k:
            heapq.heappop(max_heap)

    return -max_heap[0]



nums = [5, 7, 4, 9, 2, 6, 1, 8]
k = 2
print(kth_smallest_element(nums, k))