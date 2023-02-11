# There will be N stalls, with their co-ordinates given in the stalls array.
# We have to place k cows in the stalls such that the minimum distance between any two cows is maximum.

def can_place_cows(stalls, n, cows_count, min_dis):
    cows_placed = 1
    last_position = stalls[0]

    for i in range(1, n):
        if stalls[i] - last_position >= min_dis:
            cows_placed += 1
            last_position = stalls[i]
        
        if cows_placed >= cows_count:
            return True
    
    return False
    

def aggressive_cows(stalls, k):
    n = len(stalls)
    stalls.sort()

    low = 1
    high = stalls[-1] - stalls[0]
    ans = 0

    while low <= high:
        mid = (low + high) // 2

        if can_place_cows(stalls, n, k, mid):
            ans = mid
            low = mid + 1
        else:
            high = mid - 1
    
    return ans
    

stalls = [0, 3, 4, 7, 10, 9]
k = 4
print(aggressive_cows(stalls, k))