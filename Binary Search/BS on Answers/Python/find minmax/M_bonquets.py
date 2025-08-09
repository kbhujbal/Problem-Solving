def m_bouquets(bloomday, m, k):
    n = len(bloomday)
    
    if m * k > n:
        return -1
    
    low = min(bloomday)
    high = max(bloomday)
    res = -1

    while low <= high:
        mid = (low + high) // 2

        if can_make_bouquets(mid, bloomday):
            res = mid
            high = mid - 1
        else:
            low = mid + 1
    
    return res
    

def can_make_bouquets(day, bloomday):
    bouquets_made = 0
    adjacent_flowers = 0

    for b_day in bloomday:
        if b_day <= day:
            adjacent_flowers += 1

            if adjacent_flowers == k:
                bouquets_made += 1
                adjacent_flowers = 0
        else:
            adjacent_flowers = 0
        
    return bouquets_made >= m


bloomday = [1,10,3,10,2]
m = 3
k = 1
print(m_bouquets(bloomday, m, k))