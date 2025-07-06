from Graph import Graph
from copy import deepcopy

def flood_fill(image, sr, sc, newColor):
    rows, cols = len(image), len(image[0])
    original_color = image[sr][sc]

    if original_color == newColor:
        return deepcopy(image)
    
    result = deepcopy(image)

    def dfs(r, c):
        if(r < 0 or r>= rows or c < 0 or c >= cols or result[r][c] != original_color):
            return 
        
        result[r][c] = newColor

        dfs(r + 1, c)
        dfs(r - 1, c)
        dfs(r, c + 1)
        dfs(r, c - 1)

    dfs(sr, sc)
    return result

image = [[1,1,1],[1,1,0],[1,0,1]]
sr, sc, newColor = 1, 1, 2

ans = flood_fill(image, sr, sc, newColor)
print(ans)