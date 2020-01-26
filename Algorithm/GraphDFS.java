package com.bamzhy.My_LeetCode.Algorithm;

import com.bamzhy.My_LeetCode.Pojo.Graph;

import java.util.ArrayList;

public class GraphDFS {
    private Graph G;
    private boolean[] visited;
    private ArrayList<Integer> order = new ArrayList<>();

    public GraphDFS(Graph G) {
        this.G = G;
        visited = new boolean[G.getV()];
        for (int v = 0; v < G.getV(); v++) {
            if (!visited[v]) {
                dfs(v);
            }
        }
    }

    private void dfs(int v) {
        visited[v] = true;
        order.add(v);
        for (int w : G.adj(v)) {
            if (!visited[w]) {
                dfs(w);
            }
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

    public static void main(String[] args) {
        Graph graph = new Graph("/home/bamzhy/Desktop/LeetCode/src/com/bamzhy/My_LeetCode/File/g.txt");
        GraphDFS graphDFS = new GraphDFS(graph);
        System.out.println(graphDFS.order());
    }
}
