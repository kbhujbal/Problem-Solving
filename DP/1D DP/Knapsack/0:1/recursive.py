def recursive_knapsack(weights, values, W, n):
    if n == 0 or W == 0:
        return 0

    if weights[n - 1] > W:
        return recursive_knapsack(weights, values, W, n - 1)
    else:
        include_item = values[n - 1] + recursive_knapsack(weights, values, W - weights[n - 1], n - 1)
        exclude_item = recursive_knapsack(weights, values, W, n - 1)

        return max(include_item, exclude_item)

if __name__ == "__main__":
    weights = [10, 20, 30]
    values = [60, 100, 120]
    W = 50
    n = len(values)

    max_profit = recursive_knapsack(weights, values, W, n)
    print(f"Maximum value possible: {max_profit}")
