# Leetcode 3228
# Maximum number of operations to move ones to the end

def maxOperations(s):
    n = len(s)
    total_ops = 0
    ones_count = 0

    for i in range(n):
        if s[i] == '1':
            ones_count += 1
        else:
            if i > 0 and s[i-1] == '1':
                total_ops += ones_count
    
    return total_ops


s = "1001101"
print(maxOperations(s))