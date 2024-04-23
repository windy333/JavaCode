import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// BFS 类
public class BFS {
    // 静态BFS方法
    public static void bfs(GraphInterface graph, int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int adjVertex : graph.getAdjVertices(vertex)) {
                if (!visited.contains(adjVertex)) {
                    visited.add(adjVertex);
                    queue.add(adjVertex);
                }
            }
        }
        System.out.println();
    }
}