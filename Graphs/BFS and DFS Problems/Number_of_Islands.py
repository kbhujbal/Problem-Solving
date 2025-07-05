def numberOfIslands(isConnected):
    n = len(isConnected)
    visited = [0] * n

    def dfs(i):
        for j in range(n):
            if isConnected[i][j] == 1 and visited[j] == 0:
                visited[j] = 1
                dfs(j)

    provinces = 0
    for i in range(n):
        if visited[i] == 0:
            dfs(i)
            provinces += 1
    
    return provinces



isConnected = [[1,1,0],[1,1,0],[0,0,1]]
islands = numberOfIslands(isConnected)
print(islands)

# [1,1,0]
# [1,1,0]
# [0,0,1]