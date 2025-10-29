# Lower Bound
# The lower bound of a value x in a sorted array is the first position where x can be inserted without changing the order of the array.
# In other words:

# It returns the index of the first element that is greater than or equal to x.

# If x exists, it points to the first occurrence.

# If x doesn't exist, it tells where x can be inserted.

# Think of it as:
# "Find the smallest index i such that arr[i] >= x"


def lower_bound(arr, num):
    n = len(arr)

    low = 0
    high = n - 1
    ans = n

    while (low <= high):
        mid = int((low + high) / 2)

        if (arr[mid] >= num):
            ans = mid
            high = mid - 1
        else:
            low = mid + 1

    return ans


arr = [1, 2, 3, 3, 5, 8, 8, 10, 10, 11]
num = 8
print(lower_bound(arr, num))