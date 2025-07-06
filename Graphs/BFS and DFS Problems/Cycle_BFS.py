from collections import deque
from Graph import Graph

def has_cycle_bfs(graph):
    visited = set()

    for node in graph.adj:
        if node not in visited:
            if bfs_detect_cycle(graph, node, visited):
                return True
    return False

def bfs_detect_cycle(graph, start, visited):
    parent = {start : None}
    queue = deque()
    queue.append(start)
    visited.add(start)

    while queue:
        current = queue.popleft()

        for neighbor in graph.adj[current]:
            if neighbor not in visited:
                visited.add(neighbor)
                parent[neighbor] = current
                queue.append(neighbor)
            elif parent[current] != neighbor:
                return True
    
    return False
    


if __name__ == "__main__":
    g = Graph()

    g.add_edge('1', '2')
    g.add_edge('1', '3')
    g.add_edge('2', '5')
    g.add_edge('3', '6')
    g.add_edge('3', '4')
    g.add_edge('5', '7')
    g.add_edge('6', '7')

    # Graph looks like following : 
    # {
    #     1 ->  [2, 3]
    #     2 -> [1, 5]
    #     3 -> [1, 4, 6]
    #     4 -> [3]
    #     5 -> [2, 7]
    #     6 -> [3, 7]
    #     7 -> [5, 6]
    # }

    if has_cycle_bfs(g):
        print("Cycle Detected in Graph")
    else:
        print("No Cycle in Graph")