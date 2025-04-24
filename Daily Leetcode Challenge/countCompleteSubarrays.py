from collections import defaultdict

class Solution:
    def countCompleteSubarrays(self, nums):
        n = len(nums)
        total_unique = len(set(nums))
        count = 0

        left = 0
        freq = defaultdict(int)
        for right in range(n):
            freq[nums[right]] += 1
            while len(freq) == total_unique:
                count += n - right
                freq[nums[left]] -= 1
                if freq[nums[left]] == 0:
                    del freq[nums[left]]
                left += 1
        return count

if __name__ == "__main__":
    nums = [1, 3, 1, 2, 2]  
    solution = Solution()
    result = solution.countCompleteSubarrays(nums)
    print("Number of complete subarrays:", result)
