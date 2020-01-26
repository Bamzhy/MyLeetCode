package com.bamzhy.My_LeetCode.Pojo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdjMatrix {

    private int V;
    private int E;
    private int[][] adj;

    public AdjMatrix(String fileName) {
        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file)) {
            V = scanner.nextInt();
            E = scanner.nextInt();

            if (V < 0) throw new IllegalArgumentException("V must be non-negative");
            if (E < 0) throw new IllegalArgumentException("E must be non-negative");

            adj = new int[V][V];
            for (int i = 0; i < E; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                validateVertex(a);
                validateVertex(b);
                adj[a][b] = 1;
                adj[b][a] = 1;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex " + v + " is invalid");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("V = ").append(V).append("  E = ").append(E).append("\n");

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                sb.append(adj[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AdjMatrix adjMatrix = new AdjMatrix("/home/bamzhy/Desktop/LeetCode/src/com/bamzhy/My_LeetCode/File/g.txt");
        System.out.println(adjMatrix.toString());
    }
}
