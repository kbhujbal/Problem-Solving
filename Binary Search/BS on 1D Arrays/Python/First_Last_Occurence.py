def first_last_occurence(nums, x):
    first = LowerBound(nums, x)
    last = UpperBound(nums, x) - 1

    if first == len(nums) or nums[first] != x:
        return [-1, -1]
    else:
        return [first, last]

    
def LowerBound(nums, x):
    n = len(nums)

    low = 0
    high = n - 1

    ans = n

    while low <= high:
        mid = int((low + high)/2)

        if nums[mid] >= x:
            ans = mid
            high = mid - 1
        else:
            low = mid + 1

    return ans


def UpperBound(nums, x):
    n = len(nums)

    low = 0
    high = n - 1

    ans = n

    while low <= high:
        mid = int((low + high)/2)

        if nums[mid] > x:
            ans = mid
            high = mid - 1
        else:
            low = mid + 1

    return ans



nums = [5, 7, 7, 8, 8, 10]
x = 6
print(first_last_occurence(nums, x))