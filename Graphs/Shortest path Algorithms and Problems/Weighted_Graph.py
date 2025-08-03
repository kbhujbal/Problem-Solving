from collections import defaultdict

class Graph:
    def __init__(self, directed=False):
        self.adj = defaultdict(list)
        self.directed = directed

    def add_edge(self, u, v, weight):
        self.adj[u].append((v, weight))
        if not self.directed:
            self.adj[v].append((u, weight))
