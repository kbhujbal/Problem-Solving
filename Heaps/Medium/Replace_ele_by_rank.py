def replace_elements_by_rank(arr):
    sorted_unique = sorted(set(arr))

    rank_map = {}

    for i, num in enumerate(sorted_unique):
        rank_map[num] = i + 1

    result = []

    for num in arr:
        result.append(rank_map[num])

    return result

arr = [20, 30, 10, 50, 40]
print(replace_elements_by_rank(arr))