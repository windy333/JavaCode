import java.util.*;

//迪杰斯特拉算法
public class Dijkstra {

    public static Map<Integer, Integer> dijkstra(GraphInterface graph, int source) {
        Map<Integer, Integer> distances = new HashMap<>();
        PriorityQueue<VertexDistancePair> priorityQueue = new PriorityQueue<>();
        Set<Integer> visited = new HashSet<>();

        // 初始化距离表，将所有顶点的距离设置为无穷大，除了源点设置为0
        for (int vertex : graph.getAllVertices()) {
            if (vertex == source) {
                distances.put(vertex, 0);
            } else {
                distances.put(vertex, Integer.MAX_VALUE);
            }
            priorityQueue.add(new VertexDistancePair(vertex, distances.get(vertex)));
        }

        while (!priorityQueue.isEmpty()) {
            // 从优先队列中取出距离最小的顶点
            VertexDistancePair currentPair = priorityQueue.poll();
            int currentVertex = currentPair.vertex;
            if (visited.contains(currentVertex)) {
                continue;
            }
            visited.add(currentVertex);

            // 遍历所有邻接的顶点
            for (int neighbor : graph.getAdjVertices(currentVertex)) {
                // 如果找到更短的路径，则更新距离表和优先队列
                int edgeWeight = graph.getWeight(currentVertex, neighbor);
                int newDistance = distances.get(currentVertex) + edgeWeight;
                if (newDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newDistance);
                    priorityQueue.add(new VertexDistancePair(neighbor, newDistance));
                }
            }
        }

        return distances;
    }

    // 辅助类，用于表示顶点和距离的对，并实现 Comparable 接口以便在优先队列中使用
    private static class VertexDistancePair implements Comparable<VertexDistancePair> {
        int vertex;
        int distance;

        VertexDistancePair(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(VertexDistancePair other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

}

