import math

def smallestDivisor(nums, threshold):
    low, high = 1, max(nums)

    res = high

    while low <= high:
        mid = (low + high) // 2

        sum = 0
        for num in nums:
            sum += math.ceil(num / mid)
        
        if sum <= threshold:
            res = mid
            high = mid - 1
        else:
            low = mid + 1

    return res

nums = [44,22,33,11,1]
threshold = 5
print(smallestDivisor(nums, threshold))