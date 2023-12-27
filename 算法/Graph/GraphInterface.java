import java.util.List;
import java.util.Set;

/*
    为了使 BFS 类和DFS类既可以被 Graph 使用也可以被 Digraph 使用，需要
    定义一个接口或者一个抽象类。
 */
public interface GraphInterface {
    /*BFS 类和DFS类就可以通过这个接口与两种图交互，不用关心它是处理的 Graph 还是 Digraph。*/
    List<Integer> getAdjVertices(int vertex);

    //实现Dijkstra定义的两个抽象方法
    Set<Integer> getAllVertices();
    int getWeight(int vertex1, int vertex2);
    }

