def squares_of_sorted_array(nums):
    n = len(nums)

    if not nums:
        return 0

    result = [0] * n

    left = 0
    right = n - 1

    for k in range(n - 1, -1, -1):
        left_square = nums[left] * nums[left]
        right_square = nums[right] * nums[right]

        if left_square > right_square:
            result[k] = left_square
            left += 1
        else:
            result[k] = right_square
            right -= 1

    return result


nums = [-4, -1, 0, 3, 10]
print(squares_of_sorted_array(nums))