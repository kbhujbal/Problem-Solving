def trapping_rain_water(height):
    n = len(height)

    left = 0
    right = n - 1

    max_left = 0
    max_right = 0

    total_water = 0

    while left < right:
        if height[left] < height[right]:
            if height[left] >= max_left:
                max_left = height[left]
            else:
                total_water += max_left - height[left]

            left += 1
        else:
            if height[right] >= max_right:
                max_right = height[right]
            else:
                total_water += max_right - height[right]
            
            right -= 1

    return total_water



height = [0,1,0,2,1,0,1,3,2,1,2,1]
print(trapping_rain_water(height))