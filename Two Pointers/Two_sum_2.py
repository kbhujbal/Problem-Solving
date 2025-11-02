def two_sum_2(numbers, target):
    n = len(numbers)
    left = 0
    right = n - 1

    while left < right:
        current_sum = numbers[left] + numbers[right]

        if current_sum == target:
            return [left + 1, right + 1]
        elif current_sum < target:
            left += 1
        else:
            right -= 1

numbers = [2, 7, 11, 15]
target = 9
print(two_sum_2(numbers, target))