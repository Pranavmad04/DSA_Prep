import java.util.*;
class KruskalAlgorithm {
    static class Edge implements Comparable<Edge> {
        int source, destination, weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }
    private int vertices;
    private List<Edge> edges;

    public KruskalAlgorithm(int vertices) {
        this.vertices = vertices;
        this.edges = new ArrayList<>();
    }

    public void addEdge(int source, int destination, int weight) {
        edges.add(new Edge(source, destination, weight));
    }
    public List<Edge> kruskalMST() {
        List<Edge> mst = new ArrayList<>();
        Collections.sort(edges);

        int[] parent = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
        }

        for (Edge edge : edges) {
            int rootSource = find(parent, edge.source);
            int rootDest = find(parent, edge.destination);

            if (rootSource != rootDest) {
                mst.add(edge);
                union(parent, rootSource, rootDest);
            }
        }

        return mst;
    }
    private int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent, parent[vertex]);
        }
        return parent[vertex];
    }

    private void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        parent[rootX] = rootY;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        KruskalAlgorithm kruskal = new KruskalAlgorithm(vertices);

        System.out.println("Enter the edges (source, destination, weight) for the graph:");
        while (true) {
            System.out.print("Enter source (-1 to exit): ");
            int source = scanner.nextInt();
            if (source == -1) break;

            System.out.print("Enter destination: ");
            int destination = scanner.nextInt();

            System.out.print("Enter weight: ");
            int weight = scanner.nextInt();

            kruskal.addEdge(source, destination, weight);
        }

        List<Edge> mst = kruskal.kruskalMST();

        System.out.println("\nMinimum Spanning Tree using Kruskal's Algorithm:");
        for (Edge edge : mst) {
            System.out.println("Edge: " + edge.source + " - " + edge.destination + "  Weight: " + edge.weight);
        }
    }
}
