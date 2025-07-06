from Graph import Graph

def dfs(graph, start, visited = None):
    if visited is None:
        visited = set()

    visited.add(start)
    print(start, end=' ')

    for neighbor in graph.adj[start]:
        if neighbor not in visited:
            dfs(graph, neighbor, visited)


if __name__ == "__main__":
    g = Graph(directed=False)

    g.add_edge('1', '2')
    g.add_edge('2', '5')
    g.add_edge('2', '6')
    g.add_edge('1', '3')
    g.add_edge('3', '4')
    g.add_edge('3', '7')
    g.add_edge('4', '8')
    g.add_edge('7', '8')

    print("DFS of a graph is")
    dfs(g, '1')