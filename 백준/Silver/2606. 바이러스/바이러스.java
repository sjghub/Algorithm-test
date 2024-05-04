import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static StringTokenizer st;
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();
    static int cc =0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        for(int i=0;i<n+1;i++)
            graph.add(new ArrayList<>());
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            graph.get(j).add(k);
            graph.get(k).add(j);
        }
        visited = new boolean[n+1];
        dfs(1);
        System.out.println(cc);

    }
    public static void bfs(int R){
        visited[R] = true;
        queue.offer(R);
        int cnt = 0;
        while(!queue.isEmpty()){
            int value = queue.poll();
            for(int i=0; i<graph.get(value).size(); i++){
                if(!visited[graph.get(value).get(i)]){
                    visited[graph.get(value).get(i)] = true;
                    queue.offer(graph.get(value).get(i));
                }
            }
            cnt++;
        }
        System.out.print(cnt-1);
    }
    public static void dfs(int R){
        visited[R] = true;
        for(int i=0; i<graph.get(R).size(); i++){
            if(!visited[graph.get(R).get(i)]){
                dfs(graph.get(R).get(i));
                cc++;
            }
        }
    }
}