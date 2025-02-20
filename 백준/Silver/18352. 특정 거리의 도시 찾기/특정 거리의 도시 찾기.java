import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //도시 갯수
        int m = Integer.parseInt(st.nextToken()); //도로의 정보
        int k = Integer.parseInt(st.nextToken()); //거리 정보(최단 거리)
        int x = Integer.parseInt(st.nextToken()); //출발 도시의 번호

        Node[] nodes = new Node[n+1];
        List<ArrayList<Node>> list = new ArrayList<>();
        int[] dik = new int[n+1];
        boolean[] visited = new boolean[n+1];
        for(int i=0; i<n+1; i++) {
            list.add(new ArrayList<>());
        }
        for(int i=0;i<m; i++){
            st = new StringTokenizer(br.readLine());
            list.get(Integer.parseInt(st.nextToken())).add(new Node(Integer.parseInt(st.nextToken())));
        }
        for(int i=0;i<n+1;i++){
            dik[i] = Integer.MAX_VALUE;
        }
        dik[x] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visited[x] = true;
        while(!q.isEmpty()){
            int curIdx = q.poll();
            ArrayList<Node> nextNodes = list.get(curIdx);
            for(Node node : nextNodes){
                dik[node.destinationNum] = Math.min(dik[node.destinationNum], dik[curIdx] + 1);
                if(!visited[node.destinationNum]){
                    q.add(node.destinationNum);
                    visited[node.destinationNum] = true;
                }
            }

        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<n+1; i++){
            if(dik[i] == k)
                sb.append(i).append("\n");
        }
        if(sb.length() == 0)
            System.out.println(-1);
        else
            System.out.println(sb.toString());


    }
}
class Node{
    int destinationNum;
    int cost=1;

    Node(int destinationNum){
        super();
        this.destinationNum = destinationNum;

    }
}


