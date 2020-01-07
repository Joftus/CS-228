# Finding-a-Longest-Path-in-an-Acyclic-Graph
If the graph is acyclic, then the DFS algorithm returns a list
of all vertices in a topological order. Otherwise, it returns null. The iterative DFS
algorithm can process a large graph without stack memory overflow, because it is more
efficient in space than a recursive DFS algorithm. The maxPath algorithm produces
a stack of all vertices in a longest path (in an acyclic graph) along the distance of the
path, with the stack top being the first vertex in the path.
Both algorithms are supposed to work on a directed graph, in which each edge
goes from a starting vertex to an ending vertex, meaning that the ending vertex can
be reached from the starting vertex. In addition, each edge has a cost, which can be
positive or negative or 0. A directed graph has a cycle if it contains a sequence of
edges from a vertex back to itself, such as an edge from vertex A to vertex B, an edge
from vertex B to vertex C, and an edge from vertex C to vertex A. A directed graph
is acyclic if it has no cycles. The DFS algorithm is used to check if a directed graph is
acyclic. For example, on the above cycle of three edges from vertex A to itself, if the
vertex A is the first vertex on the cycle reached during the search, then the vertex A
is colored red, with the vertices B and C remaining green, and eventually, the vertex
B is reached during the search. When the edge from the vertex B to the vertex A is
explored during the search, the color of A is found to be still red. Thus, a cycle is
detected if an ending vertex is found to be red during the DFS search. If no cycles
are found, then the DFS algorithm produces a stack of all vertices in a topological
order, with the stack top being the first vertex in the order. A topological order of
an acyclic graph has the property that if any vertex u comes before any vertex w in
the order, then the graph has no edge from the vertex w to the vertex u. The stack is
empty initially. When the DFS search is completed at a vertex by coloring it black,
the vertex is pushed onto the stack.
The maxPath algorithm finds a path with the maximum distance in a directed
acyclic graph with each edge having a positive or non-positive cost. Here the distance
of a path in the graph is the sum of costs of each edge in the path. Let cost(u, v) be
the cost of an edge from vertex u to vertex v. Initially, set dist[u] to 0 and pred[u]
to null for each vertex u. Then for each vertex u in a topological order, perform the
1
following computation for each edge from the vertex u to another vertex v: compute
newdist = dist[u]+cost(u, v), and if newdist is larger than dist[v], then set dist[v] to
newdist and pred[v] to u. Let end be a vertex such that dist[end] ≥ dist[u] for each
vertex u. Then end is the last vertex on a path with the maximum distance dist[end].
Each vertex in this path can be found by using the pred map starting from the vertex
end. For example, if pred[end] is not null, then pred[end] is the vertex immediately
before end in the path. The starting vertex s in the path is the first vertex such that
pred[s] is null.
