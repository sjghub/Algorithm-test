import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Node>> graph;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken()); // 정점 개수
        int e = Integer.parseInt(st.nextToken()); // 간선 개수
        int startPoint = Integer.parseInt(br.readLine()); 

        graph = new ArrayList<>();
        dist = new int[v + 1];

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
            dist[i] = INF;
        }


        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v2, w));
        }

        dijkstra(startPoint);


        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            sb.append(dist[i] == INF ? "INF" : dist[i]).append("\n");
        }
        System.out.print(sb);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int curIndex = current.endIndex;
            int curCost = current.cost;

            if (curCost > dist[curIndex]) continue;

            for (Node next : graph.get(curIndex)) {
                int nextIndex = next.endIndex;
                int nextCost = curCost + next.cost;
                if (nextCost < dist[nextIndex]) {
                    dist[nextIndex] = nextCost;
                    pq.offer(new Node(nextIndex, nextCost));
                }
            }
        }
    }
}

class Node {
    int endIndex, cost;

    Node(int endIndex, int cost) {
        this.endIndex = endIndex;
        this.cost = cost;
    }
}