def find_k_closest(arr, k, x):
    l, r = 0, len(arr) - k

    while l < r:
        mid = (l + r) // 2
        if (x - arr[mid]) > (arr[mid + k] - x):
            l = mid + 1
        else:
            r = mid
    
    return arr[l:l+k]



arr = [1, 2, 3, 4, 5]
k = 4
x = 3
print(find_k_closest(arr, k, x))