# Upper Bound
# The upper bound of a value x is the first position where x can be inserted after all occurrences of x in the array.

# In other words:

# It returns the index of the first element that is strictly greater than x.

# If x exists multiple times, it gives the next index after the last occurrence.

# Think of it as:
# "Find the smallest index i such that arr[i] > x"


def upper_bound(arr, num):
    n = len(arr)

    low = 0 
    high = n - 1

    ans = n

    while (low <= high):
        mid = int((low + high)/2)

        if (arr[mid] > num):
            ans = mid
            high = mid - 1
        else:
            low = mid + 1
    
    return ans



arr = [2, 3, 6, 7, 8, 8, 11, 11, 11, 12]
num = 8
print(upper_bound(arr, num))