# Here array1 will have 0's at the end 
# And we'll have to put numbers from array2 into the array1
# final outcome must be sorted nums1 array


def merge_sorted_array(nums1, m, nums2, n):
    p1 = m - 1
    p2 = n - 1
    write_index = m + n - 1

    while p2 >= 0:
        if p1 >= 0 and nums1[p1] > nums2[p2]:
            nums1[write_index] = nums1[p1]
            p1 -= 1
        else:
            nums1[write_index] = nums2[p2]
            p2 -= 1
        
        write_index -= 1


nums1 = [1, 2, 3, 0, 0, 0]
nums2 = [2, 5, 6]
m = 3
n = 3
merge_sorted_array(nums1, m, nums2, n)
print(nums1)