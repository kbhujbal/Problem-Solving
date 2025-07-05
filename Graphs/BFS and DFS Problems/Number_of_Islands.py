# Number of Connected Components or Number of Islands
# Leetcode problem #200
from collections import deque

def numberOfIslands(grid):
    if not grid:
        return 0
    
    rows, cols = len(grid), len(grid[0])
    islands = 0

    def bfs(r, c):
        queue = deque()
        queue.append((r, c))
        grid[r][c] = 0

        while queue:
            row, col = queue.popleft()
            directions = [(-1, 0), (1, 0), (0, -1), (0, 1), 
                          (-1, -1), (-1, 1), (1, -1), (1, 1)]

            for dr, dc in directions:
                nr, nc = row + dr, col + dc
                if 0 <= nr < rows and 0 <= nc < cols and grid[nr][nc] == 1:
                    queue.append((nr, nc))
                    grid[nr][nc] = 0  


    for r in range(rows):
        for c in range(cols):
            if grid[r][c] == 1:
                bfs(r, c)
                islands += 1

    
    return islands


grid = [[0, 1, 1, 0], [0, 1, 1, 0], [0, 0, 1, 0], [0, 0, 0, 0], [1, 1, 0, 1]]
ans = numberOfIslands(grid)
print("There are total", ans, "islands")