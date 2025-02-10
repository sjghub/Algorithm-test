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
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();;
        }
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    dfs(j,i,map[i][j]);
                    cnt++;
                }
            }
        }
        System.out.print(cnt+" ");
        cnt = 0;
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                visited[i][j] = false;
                if(map[i][j] == 'R') {
                    map[i][j] = 'G';
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    dfs(j,i,map[i][j]);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);

    }

    static void dfs(int x, int y,char color){
        if(x>=N || y>=N || x<0 || y<0) return;
        if(visited[y][x] || map[y][x] != color) return;
        visited[y][x] = true;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            dfs(nx,ny,color);

        }
    }

}

