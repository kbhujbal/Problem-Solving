# This solution in O(n) whereas heap based solution is O(n logn)
# This solution uses bucket sort algorithm, in which we create list of lists
# Total N lists are present in the outer list (N is the size of nums array)

import heapq
from typing import Counter

def top_K_frequent_bucketSort(nums):
    counts = Counter(nums)

    buckets = [[] for _ in range(len(nums) + 1)]

    for num, freq in counts.items():
        buckets[freq].append(num)

    result =[]
    
    for i in range(len(buckets) - 1, 0, -1):
        if not buckets[i]:
            continue

        for num in buckets[i]:
            result.append(num)

            if len(result) == k:
                return result
    
    return result

def top_K_frequent_heap(nums):
    counts = Counter(nums)

    min_heap = []

    for num, freq in counts.items():
        heapq.heappush(min_heap, (freq, num))

        if len(min_heap) > k:
            heapq.heappop(min_heap)
        
    
    result = []
    for freq, num in min_heap:
        result.append(num)

    return result

nums = [1, 2, 1, 2, 1, 2, 3, 1, 3, 2, 4, 5, 6, 7]
k = 3
print(top_K_frequent_bucketSort(nums))