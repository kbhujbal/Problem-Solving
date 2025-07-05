from collections import defaultdict

class Graph:
    def __init__(self, directed=False):
        self.graph = defaultdict(list)
        self.directed = directed

    def add_edge(self, u, v):
        self.graph[u].append(v)
        if not self.directed:
            self.graph[v].append(u)

    def get_neighbors(self, node):
        return self.graph[node]

    def get_nodes(self):
        return list(self.graph.keys())
