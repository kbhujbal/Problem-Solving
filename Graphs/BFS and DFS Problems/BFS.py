from collections import defaultdict, deque

class Graph:
    def __init__(self):
        self.graph = defaultdict(list)

    def add_edge(self, u, v):
        self.graph[u].append(v)
        # For undirected graph, uncomment below:
        # self.graph[v].append(u)

    def bfs(self, start):
        visited = set()
        queue = deque()

        visited.add(start)
        queue.append(start)

        while queue:
            node = queue.popleft()
            print(node, end=' ')

            for neighbor in self.graph[node]:
                if neighbor not in visited:
                    visited.add(neighbor)
                    queue.append(neighbor)

# Example usage:
g = Graph()
g.add_edge('A', 'B')
g.add_edge('A', 'C')
g.add_edge('B', 'D')
g.add_edge('B', 'E')
g.add_edge('C', 'F')
g.add_edge('E', 'F')

print("BFS starting from A:")
g.bfs('A')
