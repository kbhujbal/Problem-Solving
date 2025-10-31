def apply_operations(nums):
    for i in range(len(nums) - 1):
        if nums[i] == nums[i + 1]:
            nums[i] = nums[i] * 2
            nums[i + 1] = 0

    count = 0

    for num in nums:
        if num != 0:
            nums[count] = num
            count += 1
    
    while count < len(nums):
        nums[count] = 0
        count += 1
    
    return nums



nums = [1, 2, 2, 1, 1, 0]
print(apply_operations(nums))