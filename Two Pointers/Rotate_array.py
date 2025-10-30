def rotate_array(nums, k):
    n = len(nums)

    k = k % n

    def reverse_in_place(start, end):
        while start < end:
            nums[start], nums[end] = nums[end], nums[start]

            start += 1
            end -= 1

    reverse_in_place(0, n - 1)
    reverse_in_place(0, k - 1)
    reverse_in_place(k, n - 1)


nums = [1, 2, 3, 4, 5, 6, 7]
k = 3
rotate_array(nums, k)
print(nums)