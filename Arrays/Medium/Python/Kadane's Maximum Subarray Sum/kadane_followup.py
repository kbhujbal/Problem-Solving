def maximum_subarray(nums):
    current_max = nums[0]
    max_so_far = nums[0]

    best_start = 0
    best_end = 0

    temp_start = 0

    for i in range(1, len(nums)):
        if nums[i] > current_max + nums[i]:
            current_max = nums[i]
            temp_start = i
        else:
            current_max += nums[i]
        
        if current_max > max_so_far:
            max_so_far = current_max 
            best_start = temp_start
            best_end = i

    return max_so_far, nums[best_start : best_end + 1]


nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
print(maximum_subarray(nums))