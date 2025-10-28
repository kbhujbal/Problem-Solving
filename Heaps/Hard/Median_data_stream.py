import heapq

class MedianFinder:
    def __init__(self):
        self.small_heap = []
        self.large_heap = []

    def add(self, num):
        heapq.heappush(self.small_heap, -num)

        largest_in_small = - heapq.heappop(self.small_heap)
        heapq.heappush(self.large_heap, largest_in_small)

        if len(self.large_heap) > len(self.small_heap):
            smallest_in_large = heapq.heappop(self.large_heap)
            heapq.heappush(self.small_heap, -smallest_in_large)
    

    def findMedian(self):
        if len(self.small_heap) > len(self.large_heap):
            return -self.small_heap[0]
        else:
            return ((-self.small_heap[0]) + (self.large_heap[0])) / 2
        
obj = MedianFinder()

obj.add(3)
obj.add(2)
med = obj.findMedian()
print(med)
obj.add(1)
med = obj.findMedian()
print(med)
