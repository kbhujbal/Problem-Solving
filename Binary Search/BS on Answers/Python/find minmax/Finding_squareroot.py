# Problem Statement: You are given a positive integer n. 
# Your task is to find and return its square root. 
# If ‘n’ is not a perfect square, then return the floor value of sqrt(n).

def find_int_squareroot(n):
    if n < 2:
        return n
    
    low, high = 1, n

    result = 0

    while low <= high:
        mid = (low + high) // 2

        square = mid * mid

        if square == n:
            return mid
        elif square < n:
            result = mid
            low = mid + 1
        else:
            high = mid - 1
    
    return result

n = 28
print(find_int_squareroot(n))