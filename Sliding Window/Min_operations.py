# Minimum Operations to Reduce X to Zero

def min_operations_to_reduce_zero(nums, x):
    total_sum = sum(nums)
    n = len(nums)

    target_sum = total_sum - x

    if target_sum == 0:
        return n
    
    if target_sum < 0:
        return -1
    
    l = 0
    current_sum = 0
    max_length = -1

    for r in range(n):
        current_sum += nums[r]

        while current_sum > target_sum and l <= r:
            current_sum -= nums[l]
            l += 1
        
        if current_sum == target_sum:
            max_length = max(max_length, r - l + 1)
    
    if max_length == -1:
        return -1
    else:
        return n - max_length



nums = [3,2,20,1,1,3]
x = 10
print(min_operations_to_reduce_zero(nums, x))