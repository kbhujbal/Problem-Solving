def is_possible(arr, m, max_pages):
    student_count = 1
    current_pages = 0

    for pages in arr:
        if current_pages + pages > max_pages:
            student_count += 1
            current_pages = pages
            
            if student_count > m:
                return False
        else:
            current_pages += pages

    return True
        

def find_pages(arr, m):
    n = len(arr)

    if n < m:
        return -1
    
    low = max(arr)
    high = sum(arr)
    result = -1

    while low <= high:
        mid = (low + high) // 2

        if is_possible(arr, m, mid):
            result = mid 
            high = mid - 1
        else:
            low = mid + 1
    
    return result


books = [12, 34, 67, 90]
students = 2
min_max_pages = find_pages(books, students)
print(min_max_pages)