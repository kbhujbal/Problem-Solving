def search_insert_position(nums, target):
    n = len(nums)

    low = 0 
    high = n - 1
    ans = n

    while low <= high:
        mid = int((low + high)/2)

        if nums[mid] >= target:
            ans = mid
            high = mid -1
        else:
            low = mid + 1
        
    return ans



nums = [1, 3, 5, 6]
target = 2
print(search_insert_position(nums, target))