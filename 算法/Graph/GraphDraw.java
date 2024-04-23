import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import  java.util.*;


import java.io.*;

/*还是要依赖其它两个类,可以当个玩具*/
public class GraphDraw extends JFrame {
    private static final int WIDTH = 1100;
    private static final int HEIGHT = 800;
    private Map<Integer, Point> vertexPositions;
    private Map<Integer, String> vertexLabels;
    private Map<Integer, List<Edge>> edges;
    private boolean isDirected;

    private static class Edge {
        final int destination;
        final int weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    public GraphDraw(String title, boolean isDirected) {
        this.setTitle(title);
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.vertexPositions = new HashMap<>();
        this.vertexLabels = new HashMap<>();
        this.edges = new HashMap<>();
        this.isDirected = isDirected;
    }

    public void addVertex(int vertex, int x, int y, String label) {
        vertexPositions.put(vertex, new Point(x, y));
        vertexLabels.put(vertex, label);
    }

    public void addEdge(int source, int destination, int weight) {
        edges.computeIfAbsent(source, k -> new java.util.ArrayList<>()).add(new Edge(destination, weight));
        if (!isDirected) {
            edges.computeIfAbsent(destination, k -> new java.util.ArrayList<>()).add(new Edge(source, weight));
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // 画顶点
        for (Map.Entry<Integer, Point> entry : vertexPositions.entrySet()) {
            int x = entry.getValue().x;
            int y = entry.getValue().y;
            g.fillOval(x - 30, y - 30, 60, 60);
            g.drawString(vertexLabels.get(entry.getKey()), x - 15, y - 35);
        }
        // 画边
        for (Map.Entry<Integer, List<Edge>> entry : edges.entrySet()) {
            int source = entry.getKey();
            Point p1 = vertexPositions.get(source);
            for (Edge edge : entry.getValue()) {
                Point p2 = vertexPositions.get(edge.destination);
                g.drawLine(p1.x, p1.y, p2.x, p2.y);
                // 画带权的边
                g.drawString(String.valueOf(edge.weight), (p1.x + p2.x) / 2, (p1.y + p2.y) / 2 - 10);
            }
        }
    }


    public static void main(String[] args) {
        // 有向图这里可能会有显示问题，这里设置了一个参数isDirected来画无向图
        GraphDraw graphDraw = new GraphDraw("Graph Visualization", false); // Set to false for undirected graph

        // 添加顶点信息和标签
        graphDraw.addVertex(0, 200, 150, "New York");
        graphDraw.addVertex(1, 400, 300, "Los Angeles");
        graphDraw.addVertex(2, 600, 150, "Chicago");
        graphDraw.addVertex(3, 800, 300, "Houston");
        graphDraw.addVertex(4, 1000, 150, "Phoenix");

        // 添加带权的边
        graphDraw.addEdge(0, 1, 5);
        graphDraw.addEdge(0, 4, 3);
        graphDraw.addEdge(1, 2, 4);
        graphDraw.addEdge(1, 3, 8);
        graphDraw.addEdge(2, 3, 2);
        graphDraw.addEdge(3, 4, 7);

        // 展示
        graphDraw.setVisible(true);
        graphDraw.setLocationRelativeTo(null);
    }


}


