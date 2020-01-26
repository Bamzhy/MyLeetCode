package com.bamzhy.My_LeetCode.Pojo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class AdjList {

    private int V;
    private int E;
    private ArrayList<LinkedList<Integer>> adj;

    public AdjList(String fileName) {
        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file)) {
            V = scanner.nextInt();
            E = scanner.nextInt();

            if (V < 0) throw new IllegalArgumentException("V must be non-negative");
            if (E < 0) throw new IllegalArgumentException("E must be non-negative");

            adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new LinkedList<>());
            }

            for (int i = 0; i < E; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();

                validateVertex(a);
                validateVertex(b);
                if (a == b)
                    throw new IllegalArgumentException("Self Loop is Detected!");
                if (adj.get(a).contains(b))
                    throw new IllegalArgumentException("Parallel Edges are Detected");

                adj.get(a).add(b);
                adj.get(b).add(a);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean hasEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return adj.get(v).contains(w);
    }

    public LinkedList<Integer> adj(int v) {
        validateVertex(v);
        return adj.get(v);
    }

    public int degree(int v) {
        return adj(v).size();
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
            sb.append(i).append(": ");
            for (int w : adj.get(i)) {
                sb.append(w).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public static void main(String[] args) {
        AdjList adjList = new AdjList("g.txt");
        System.out.println(adjList.toString());
        System.out.println(adjList.adj(2));
        System.out.println(adjList.degree(2));
        System.out.println(adjList.hasEdge(2, 3));
        System.out.println(adjList.hasEdge(2, 6));
    }
}
