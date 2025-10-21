import collections

class Solution:
    def maxFrequency(self, nums: list[int], k: int, numOperations: int) -> int:
        line = collections.defaultdict(int)
        
        count = collections.Counter(nums)
        
        for num in nums:
            line[num - k] += 1
            line[num + k + 1] -= 1
            
        all_critical_points = set(line.keys()) | set(count.keys())
        sorted_points = sorted(list(all_critical_points))

        max_freq = 0
 
        adjustable = 0
        
        for x in sorted_points:
            adjustable += line[x]
            
            current_val_count = count[x] 
            
            needed_ops = adjustable - current_val_count
            
            used_ops = min(numOperations, needed_ops)

            total_freq_at_x = current_val_count + used_ops
            
            max_freq = max(max_freq, total_freq_at_x)
            
        return max_freq

if __name__ == "__main__":
    solver = Solution()

    nums1 = [1, 4, 5]
    k1 = 1
    numOperations1 = 2

    result1 = solver.maxFrequency(nums1, k1, numOperations1)
    print(f"Test Case 1:")
    print(f"  Input: nums = {nums1}, k = {k1}, numOperations = {numOperations1}")
    print(f"  Output: {result1}")
    print("-" * 20)

    nums2 = [5, 11, 20, 20]
    k2 = 5
    numOperations2 = 1

    result2 = solver.maxFrequency(nums2, k2, numOperations2)
    print(f"Test Case 2:")
    print(f"  Input: nums = {nums2}, k = {k2}, numOperations = {numOperations2}")
    print(f"  Output: {result2}")
    print("-" * 20)

    nums3 = [1, 2, 3]
    k3 = 1
    numOperations3 = 2

    result3 = solver.maxFrequency(nums3, k3, numOperations3)
    print(f"Test Case 3:")
    print(f"  Input: nums = {nums3}, k = {k3}, numOperations = {numOperations3}")
    print(f"  Output: {result3}")
    print("-" * 20)