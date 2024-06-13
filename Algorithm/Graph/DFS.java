import java.util.HashSet;
import java.util.List;
import java.util.Set;

// DFS 类
public class DFS {
    // 静态DFS方法
    public static void dfs(GraphInterface graph, int start) {
        Set<Integer> visited = new HashSet<>();
        dfsHelper(graph, start, visited);
        System.out.println();
    }

    //辅助方法
    private static void dfsHelper(GraphInterface graph, int vertex, Set<Integer> visited) {
        visited.add(vertex);
        System.out.print(vertex + " ");

        List<Integer> adjVertices = graph.getAdjVertices(vertex);
        for (int adjVertex : adjVertices) {
            if (!visited.contains(adjVertex)) {
                dfsHelper(graph, adjVertex, visited);
            }
        }
    }
}
