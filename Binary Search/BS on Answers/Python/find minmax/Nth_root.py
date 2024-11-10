def nth_root(num, n):
    low, high = 1, num

    ans = 1

    while low <= high:
        mid = (low + high) // 2

        n_times = 1
        for i in range(n):
            n_times *= mid
        
        if n_times == num:
            return mid
        elif n_times < num:
            low = mid + 1
        else:
            high = mid - 1

    return -1


num = 81
n = 4
print(nth_root(num, n))