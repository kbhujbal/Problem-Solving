def partition_pivot(nums, pivot):
    less_than = []
    equal_to = []
    greater_than = []

    for num in nums:
        if num < pivot:
            less_than.append(num)
        elif num == pivot:
            equal_to.append(num)
        else:
            greater_than.append(num)
            
    return less_than + equal_to + greater_than


nums = [9, 12, 5, 10, 14, 3, 10]
pivot = 10
print(partition_pivot(nums, pivot))