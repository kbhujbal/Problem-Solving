def floor_ceil(nums, x):
    floor_ = floor(nums, x)
    ceil_ = ceil(nums, x)

    return [nums[floor_], nums[ceil_]]


def floor(nums, x):
    n = len(nums)
    
    low = 0
    high = n - 1

    floor = -1

    while low <= high:
        mid = int((low + high)/2)

        if nums[mid] <= x:
            floor = mid
            low = mid + 1
            
        else:
            high = mid - 1
        
    return floor


def ceil(nums, x):
    n = len(nums)
    
    low = 0
    high = n - 1

    ceil = n

    while low <= high:
        mid = int((low + high)/2)

        if nums[mid] > x:
            ceil = mid
            high = mid - 1
        else:
            low = mid + 1
        
    return ceil


nums = [3, 4, 4, 7, 8, 10]
x = 5
floor_ceil = floor_ceil(nums, x)
print("Floor : ", floor_ceil[0])
print("Ceil: ", floor_ceil[1])