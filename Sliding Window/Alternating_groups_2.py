def alternating_groups_2(colors, k):
    n = len(colors)

    alternating = 1
    ans = 0

    for i in range(1, n + k - 1):
        current_index = i % n
        previous_index = (i - 1) % n

        if colors[current_index] == colors[previous_index]:
            alternating = 1
        else:
            alternating += 1

        if alternating >= k:
            ans += 1

    return ans

colors = [0,1,0,0,1,0,1]
k = 6
print(alternating_groups_2(colors, k))