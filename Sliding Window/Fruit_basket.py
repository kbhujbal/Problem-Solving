def fruit_basket(fruits):
    fruit_counts = {}

    max_fruits = 0
    window_start = 0

    for window_end in range(len(fruits)):
        current_fruit = fruits[window_end]
        fruit_counts[current_fruit] = fruit_counts.get(current_fruit, 0) + 1

        while len(fruit_counts) > 2:
            left_fruit = fruits[window_start]

            fruit_counts[left_fruit] -= 1

            if fruit_counts[left_fruit] == 0:
                del fruit_counts[left_fruit]

            window_start += 1
        
        current_window_size = window_end - window_start + 1
        max_fruits = max(current_window_size, max_fruits)
    
    return max_fruits


fruits = [1, 2, 3, 2, 2]
print(fruit_basket(fruits))