from collections import defaultdict

class Solution:
    def countPairs(self, nums, k):
        value_indices = defaultdict(list)
        count = 0

        for idx, num in enumerate(nums):
            value_indices[num].append(idx)

        for indices in value_indices.values():
            n = len(indices)
            for i in range(n):
                for j in range(i + 1, n):
                    if (indices[i] * indices[j]) % k == 0:
                        count += 1

        return count

if __name__ == "__main__":
    # Example input
    nums = [3, 1, 2, 2, 2, 1, 3]
    k = 2

    sol = Solution()
    result = sol.countPairs(nums, k)
    print("Number of valid pairs:", result)
