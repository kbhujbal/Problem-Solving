def move_zeros(nums):
    n = len(nums)

    count = 0

    for num in nums:
        if num != 0:
            nums[count] = num
            count += 1
    
    while count < n:
        nums[count] = 0
        count += 1
        


nums = [0, 1, 0, 3, 12]
move_zeros(nums)
print(nums)