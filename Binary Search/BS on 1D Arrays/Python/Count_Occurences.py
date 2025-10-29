def count_occurences(nums, x):
    first, last = first_last_occurence(nums, x)

    if first == -1:
        return 0
    else:
        return last - first + 1


def first_last_occurence(nums, x):
    first = LowerBound(nums, x)
    last = UpperBound(nums, x) - 1

    if first == -1:
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



nums = [2, 4, 6, 8, 8, 8, 11, 13]
x = 8
print(count_occurences(nums, x))