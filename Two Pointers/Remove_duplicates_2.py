def remove_duplicates_2(nums):
    k = 0

    for num in nums:
        if k < 2 or num > nums[k - 2]:
            nums[k] = num
            k += 1

    return k


nums = [1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 5, 6]
print(nums[:remove_duplicates_2(nums)])