import math

def koko_eating_banana(piles, h):
    low, high = 1, len(piles)

    res = high

    while low <= high:
        mid = (low + high) // 2

        total_hours = 0

        for p in piles:
            total_hours += math.ceil(p / mid)
        
        if total_hours <= h:
            res = mid
            high = mid - 1
        else:
            low = mid + 1
    
    return res



piles = [30,11,23,4,20]
h = 5