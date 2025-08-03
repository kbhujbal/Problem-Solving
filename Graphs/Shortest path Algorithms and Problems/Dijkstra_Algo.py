# Dijkstra's Algorithm Using Priority Queue

from Weighted_Graph import Graph
import heapq

def dijkstra(graph: Graph, start):
    dist = {node: float('inf') for node in graph.adj}
    dist[start] = 0

    pq = [(0, start)]

    while pq:
        current_dist, u = heapq.heappop(pq)

        if current_dist > dist[u]:
            continue

        for v, weight in graph.adj[u]:
            if dist[v] > dist[u] + weight:
                dist[v] = dist[u] + weight 
                heapq.heappush(pq, (dist[v], v))
    
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

    shortest_path = dijkstra(g, '0')
    print(shortest_path)