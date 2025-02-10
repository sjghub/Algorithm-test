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
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();;
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    bfs(i,j,map[i][j]);
                    cnt++;
                }
            }
        }
        System.out.print(cnt+" ");
        cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                visited[i][j] = false;
                if(map[i][j] == 'R') {
                    map[i][j] = 'G';
                }
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    bfs(i,j,map[i][j]);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);

    }

    static void bfs(int x,int y,char color){

        queue.add(new int[]{x, y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
                if(color == map[nx][ny]){
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }

            }
        }
    }


}

