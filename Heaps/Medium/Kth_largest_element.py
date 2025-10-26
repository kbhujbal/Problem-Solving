import heapq

def find_kth_largest_min_heap(nums, k):
    """
    Finds the Kth largest element using a min-heap of size K.
    Time: O(N log K)
    Space: O(K)
    """
    min_heap = []
    
    for num in nums:
        if len(min_heap) < k:
            heapq.heappush(min_heap, num)
        else:
            if num > min_heap[0]:
                heapq.heappushpop(min_heap, num)
                
    return min_heap[0]



nums = [3, 2, 1, 5, 6, 4]
k = 2
print(f"Method 1: The {k}nd largest element is: {find_kth_largest_min_heap(nums, k)}")

nums2 = [3, 2, 3, 1, 2, 4, 5, 5, 6]
k2 = 4
print(f"Method 1: The {k2}th largest element is: {find_kth_largest_min_heap(nums2, k2)}")