import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, -0};
    static boolean[][] visited;
    static int cnt = 0;
    static int N;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(arr[0][1]);
        for (int i = 1; i < N; i++) {

            int cur = pq.peek();
            if(cur <= arr[i][0]){
                pq.poll();
            }
            pq.offer(arr[i][1]);


        }
        System.out.println(pq.size());

    }

}

