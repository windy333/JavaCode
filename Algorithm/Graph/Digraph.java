import java.util.*;

//有向图
public class Digraph implements GraphInterface{
    private Map<Integer, List<Edge>> adjacencyList;

    // 构造函数
    public Digraph() {
        adjacencyList = new HashMap<>();
    }

    // 添加顶点
    public void addVertex(int vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }


    // 添加有向边（权重默认为1）
    public void addEdge(int source, int destination) {
        // 确保 source 在 adjacencyList 中有对应的条目
        adjacencyList.putIfAbsent(source, new ArrayList<>());

        // 创建一个新的 Edge 对象并将其添加到 source 的邻接列表中
        adjacencyList.get(source).add(new Edge(destination, 1));
    }

    // 添加有向边（带权重）
    public void addEdge(int source, int destination, int weight) {
        // 确保 source 在 adjacencyList 中有对应的条目
        adjacencyList.putIfAbsent(source, new ArrayList<>());

        // 创建一个新的 Edge 对象并将其添加到 source 的邻接列表中
        adjacencyList.get(source).add(new Edge(destination, weight));
    }


    // 打印图
    public void printGraph() {
        for (int vertex : adjacencyList.keySet()) {
            List<Edge> edges = adjacencyList.get(vertex);
            System.out.println("顶点" + vertex + " 连接边" + edges);
        }
    }


    //实现接口的方法
    public List<Integer> getAdjVertices(int vertex) {
        // 返回与顶点 vertex 相邻的顶点列表
        List<Integer> adjacentVertices = new ArrayList<>();
        if (adjacencyList.containsKey(vertex)) {
            for (Edge edge : adjacencyList.get(vertex)) {
                adjacentVertices.add(edge.to);
            }
        }
        return adjacentVertices;
    }


    // Edge 辅助类，用于表示图中的边和权重
    // 这里在Edge类中重写了 toString()方法防止打印结果出现哈希值
    private static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "到顶点 " + to + " 的权重为 " + weight;
        }
    }

    @Override
    public Set<Integer> getAllVertices() {
        // 返回图中所有顶点的集合
        return adjacencyList.keySet();
    }

    @Override
    public int getWeight(int vertex1, int vertex2) {
        // 返回顶点 vertex1 和 vertex2 之间的边的权重
        if (adjacencyList.containsKey(vertex1)) {
            for (Edge edge : adjacencyList.get(vertex1)) {
                if (edge.to == vertex2) {
                    return edge.weight;
                }
            }
        }
        return Integer.MAX_VALUE; // 如果没有边，则返回无穷大
    }

    public static void main(String[] args) {
        Digraph digraph = new Digraph();

        // 添加顶点
        digraph.addVertex(0);
        digraph.addVertex(1);
        digraph.addVertex(2);
        digraph.addVertex(3);
        digraph.addVertex(4);

        // 添加边
        digraph.addEdge(0, 1, 5);
        digraph.addEdge(0, 2, 3);
        digraph.addEdge(1, 3, 6);
        digraph.addEdge(2, 3, 4);
        digraph.addEdge(3, 4, 2);
        //digraph.addEdge(0, 1);
        //digraph.addEdge(0, 2);
        //digraph.addEdge(1, 3);
        //digraph.addEdge(2, 3);
        //digraph.addEdge(3, 4);

        // 打印图
        digraph.printGraph();
/*
        0 ----5----> 1
         \           \
          \           \
           3           6
            \           \
             \           \
              v           v
              2 ----4----> 3 ----2----> 4

 */
        //定义初始顶点
        int start = 0;

        // 直接调用静态方法执行 BFS
        System.out.println("\nBFS starting from vertex " + start + ":");
        BFS.bfs(digraph, start);

        // 直接调用静态方法执行DFS
        System.out.println("\nDFS starting from vertex " + start + ":");
        DFS.dfs(digraph, start);

        // 调用迪杰斯特拉算法
        Map<Integer, Integer> distances = Dijkstra.dijkstra(digraph, start);

        // 打印从起点到每个顶点的最短距离
        System.out.println("\nDIJkstra's shortest distances from vertex " + start + ":");
        for (Map.Entry<Integer, Integer> entry : distances.entrySet()) {
            System.out.println("To vertex " + entry.getKey() + " - Distance: " + entry.getValue());
        }
    }
}

