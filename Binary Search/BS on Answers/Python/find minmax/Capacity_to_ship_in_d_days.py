def capacity_to_ship_n_days(weights, days):
    def can_ship(capacity):
        days_needed = 1
        current_weight_on_ship = 0

        for w in weights:
            if current_weight_on_ship + w <= capacity:
                current_weight_on_ship += w
            else:
                days_needed += 1
                current_weight_on_ship = w
    
        return days_needed <= days
    
    low = max(weights)
    high = sum(weights)
    res = high

    while low <= high:
        mid = (low + high) // 2

        if can_ship(mid):
            res = mid
            high = mid - 1
        else:
            low = mid + 1

    return res



weights = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
days = 5
print(capacity_to_ship_n_days(weights, days))