import math

def minimum_size_subarray_sum(target, nums):
    l = 0

    current_sum = 0
    min_length = math.inf

    for r in range(len(nums)):
        current_sum += nums[r]

        while current_sum >= target:
            current_length = r - l + 1
            min_length = min(min_length, current_length)
            current_sum -= nums[l]
            l += 1
        
    return 0 if min_length == math.inf else min_length



nums = [2, 3, 1, 2, 4, 3]
target = 7
print(minimum_size_subarray_sum(target, nums))