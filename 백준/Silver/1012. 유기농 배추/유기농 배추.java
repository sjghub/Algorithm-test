import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[][] tree;
    static boolean[][] visited;

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int m;
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            int count = 0;
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); //가로길이
            n = Integer.parseInt(st.nextToken()); //세로길이
            int target = Integer.parseInt(st.nextToken()); //1의 위치(배추가 심어져있는)

            visited = new boolean[n][m];
            tree = new int[n][m];

            for(int k=0; k<target; k++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()); //가로
                int y = Integer.parseInt(st.nextToken()); //세로
                tree[y][x] = 1;
            }
            for(int k=0; k<n; k++){
                for(int j=0; j<m; j++){
                    if(tree[k][j] == 1 && !visited[k][j]){
                        dfs(k,j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }




    }
    public static void dfs(int y,int x){
        if(y<0 || y>=n || x<0 || x>=m) return ;
        if(visited[y][x]) return ;
        visited[y][x] = true;
        if(tree[y][x] == 0) return ;

        for(int i=0; i<4; i++){
            dfs(y+dy[i],x+dx[i]);
        }

    }











}