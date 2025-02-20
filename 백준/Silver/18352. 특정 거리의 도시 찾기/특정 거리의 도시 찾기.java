import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken()); // 도시 개수
        int m = Integer.parseInt(st.nextToken()); // 도로 정보
        int k = Integer.parseInt(st.nextToken()); // 거리 정보(최단 거리)
        int x = Integer.parseInt(st.nextToken()); // 출발 도시 번호
        
        List<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list.get(from).add(to);
        }
        
        int[] dik = new int[n + 1];
        Arrays.fill(dik, Integer.MAX_VALUE);
        dik[x] = 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        
        while (!q.isEmpty()) {
            int curIdx = q.poll();
            for (int next : list.get(curIdx)) {
                if (dik[next] == Integer.MAX_VALUE) { // 처음 방문하는 노드
                    dik[next] = dik[curIdx] + 1;
                    q.add(next);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (dik[i] == k) {
                sb.append(i).append("\n");
            }
        }
        System.out.print(sb.length() == 0 ? "-1" : sb.toString());
    }
}