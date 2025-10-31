def remove_duplicates(nums):
    n = len(nums)

    if n == 0:
        return 0

    j = 0

    for i in range(n - 1):
        if nums[i] != nums[i + 1]:
            nums[j] = nums[i]
            j += 1
    
    nums[j] = nums[n - 1]
    
    return j + 1




nums = [0, 0, 1, 1, 2, 2, 3, 4, 4, 4, 5, 5, 6, 6, 7, 7, 7]
index = remove_duplicates(nums)

for i in range(index):
    print(nums[i], end = " ")