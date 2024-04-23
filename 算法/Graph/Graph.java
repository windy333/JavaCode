import java.util.*;

// 无向图的实现
public class Graph implements GraphInterface {
    private Map<Integer, List<Integer>> adjVertices;

    public Graph() {
        adjVertices = new HashMap<>();
    }

    // 添加顶点
    public void addVertex(int vertex) {
        adjVertices.putIfAbsent(vertex, new ArrayList<>());
    }


    // 添加边
    public void addEdge(int v1, int v2) {
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1); // 对于无向图，需要在两个顶点之间互相添加
    }

    // 打印图
    public void printGraph() {
        for (int vertex : adjVertices.keySet()) {
            System.out.print("顶点" + vertex + " 连接顶点 ");
            for (int adjVertex : adjVertices.get(vertex)) {
                System.out.print(adjVertex + " ");
            }
            System.out.println();
        }
    }


    // 实现接口中的方法
    @Override
    public List<Integer> getAdjVertices(int vertex) {
        return adjVertices.getOrDefault(vertex, new ArrayList<>());
    }

    @Override
    public Set<Integer> getAllVertices() {
        return adjVertices.keySet();
    }

    // 设无向图中所有边的权重为1
    @Override
    public int getWeight(int vertex1, int vertex2) {
        if (adjVertices.get(vertex1).contains(vertex2)) {
            return 1;
        }
        return 0; // 如果两个顶点之间没有边，可以返回0或者一个代表无穷大的值
    }


    // Edge 辅助类，用于表示图中的边和权重
    private static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

    }

    // 主函数，用于测试图
    public static void main(String[] args) {
        Graph graph = new Graph();

        // 添加顶点
        for (int i = 0; i < 5; i++) {
            graph.addVertex(i);
        }

        // 添加边
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        // 打印图
        graph.printGraph();
/*
                 0
                / \
               1---4
               | \ |
               2---3
 */

        int start = 0;
        // 直接调用静态方法执行 BFS
        System.out.println("\nBFS starting from vertex " + start + ":");
        BFS.bfs(graph, start);

        // 直接调用静态方法执行DFS
        System.out.println("\nDFS starting from vertex " + start + ":");
        DFS.dfs(graph, start);

        // 调用迪杰斯特拉算法
        Map<Integer, Integer> distances = Dijkstra.dijkstra(graph, start);

        // 打印从起点到每个顶点的最短距离
        System.out.println("\nDijkstra's shortest distances from vertex " + start+ ":");
        for (Map.Entry<Integer, Integer> entry : distances.entrySet()) {
            System.out.println("To vertex " + entry.getKey() + " - Distance: " + entry.getValue());

        }
    }
}



