from Weighted_Graph import Graph

def dijkstra_set(graph: Graph, start):
    dist = {node: float('inf') for node in graph.adj}
    dist[start] = 0

    visited = set()
    node_set = set()
    node_set.add((0, start))

    while node_set:
        u = min(node_set)[1]
        node_set.remove((dist[u], u))
        visited.add(u)

        for v, weight in graph.adj[u]:
            if v in visited:
                continue
            if dist[v] > dist[u] + weight:
                if (dist[v], v) in node_set:
                    node_set.remove((dist[v], v))
                dist[v] = dist[u] + weight
                node_set.add((dist[v], v))

    return dist


if __name__ == "__main__":
    g = Graph()

    g.add_edge('0', '1', 4)
    g.add_edge('0', '2', 4)
    g.add_edge('1', '2', 2)
    g.add_edge('2', '3', 3)
    g.add_edge('2', '4', 1)
    g.add_edge('2', '5', 6)
    g.add_edge('3', '5', 2)
    g.add_edge('4', '5', 3)

    shortest_path = dijkstra_set(g, '0')
    print(shortest_path)