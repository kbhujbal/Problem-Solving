def alternate_positive_negative(nums):
    n = len(nums)

    pos_idx = 0
    neg_idx = 1

    result = [0] * n

    for num in nums:
        if num > 0:
            result[pos_idx] = num
            pos_idx += 2
        else:
            result[neg_idx] = num
            neg_idx += 2
    
    return result


nums = [3, 1, -2, -5, 2, -4]
print(alternate_positive_negative(nums))