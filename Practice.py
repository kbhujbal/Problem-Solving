import math

def practice(piles, h):
    low, high = 1, max(piles)

    ans = 0

    while low <= high:
        mid = (low + high) // 2

        total_hours = 0
        for i in piles:
            total_hours += math.ceil(i/mid)
        
        if total_hours <= h:
            ans = mid
            high = mid - 1
        else:
            low = mid + 1
        
    return ans


piles = [3, 6, 7, 11]
h = 8
print(practice(piles, h))