def sort_array_parity(nums):
    i = 0

    for j in range(len(nums)):
        if nums[j] % 2 == 0:
            nums[i], nums[j] = nums[j], nums[i]
            i += 1

    return nums
                   

nums = [3, 1, 2, 4]
print(sort_array_parity(nums))