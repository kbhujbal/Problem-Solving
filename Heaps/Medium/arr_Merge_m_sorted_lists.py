import heapq

def merge_m_sorted_lists(lists):
    min_heap = []

    for i, lst in enumerate(lists):
        if lst:
            value = lst[0]
            list_index = i
            element_index = 0
            heapq.heappush(min_heap, (value, list_index, element_index))

    result = []

    while min_heap:
        val, lst_idx, ele_idx = heapq.heappop(min_heap)

        result.append(val)

        next_ele_idx = ele_idx + 1

        if next_ele_idx < len(lists[lst_idx]):
            next_val = lists[lst_idx][next_ele_idx]
            heapq.heappush(min_heap, (next_val, lst_idx, next_ele_idx))

    return result

list1 = [1, 4, 5]
list2 = [1, 3, 4]
list3 = [2, 6]
m_lists = [list1, list2, list3]

merged = merge_m_sorted_lists(m_lists)
print(f"Original lists: {m_lists}")
print(f"Merged list:    {merged}")

# Example with an empty list
list4 = []
list5 = [1, 2, 3]
list6 = [1, 10]
m_lists_2 = [list4, list5, list6]

merged_2 = merge_m_sorted_lists(m_lists_2)
print(f"\nOriginal lists: {m_lists_2}")
print(f"Merged list:    {merged_2}")