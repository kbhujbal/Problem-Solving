def freq_of_frequent_element(nums, k):
    left = 0
    max_frequency = 0
    current_sum = 0

    for right in range(len(nums)):
        current_sum += nums[right]
        window_size = right - left + 1

        cost = (nums[right] * window_size) - current_sum

        while cost > k:
            current_sum -= nums[left]
            left += 1

            window_size = right - left + 1
            cost = (nums[right] * window_size) - current_sum

        max_frequency = max(max_frequency, window_size)
    
    return max_frequency



nums = [1, 2, 4]
k = 5
print(freq_of_frequent_element(nums, k))