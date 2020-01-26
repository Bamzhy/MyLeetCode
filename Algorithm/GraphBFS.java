package com.bamzhy.My_LeetCode.Algorithm;

import com.bamzhy.My_LeetCode.Pojo.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {
    private Graph G;
    private boolean[] visited;
    private ArrayList<Integer> order = new ArrayList<>();

    public GraphBFS(Graph G) {
        this.G = G;
        visited = new boolean[G.getV()];
        // the circle insure all nodes will be traversed
        // if we just do bfs(0), other Connected Component may not be covered
        for (int v = 0; v < G.getV(); v++) {
            if (!visited[v]) {
                bfs(v);
            }
        }
    }

    private void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        while (!queue.isEmpty()) {
            int v = queue.remove();
            order.add(v);
            for (int w : G.adj(v)) {
                queue.add(w);
                visited[w] = true;
            }
        }
    }

    public Iterable<Integer> order() {
        return order;
    }
}
