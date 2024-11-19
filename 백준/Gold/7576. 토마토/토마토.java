
/**
 * 1. 푸는 방법 둘중 짧은 것을 픽
 * <p>
 * 그 문자의 길이부터 부분문자열을 잘라서 다른 문자열이 그 부분문자열을 포함하고있는지 확인 3. 자료구조
 * <p>
 * <p>
 * 1. A 2. A+A  , A+B -> B+A 3. AAA, A+A+B -> BAA , BAA, BAB -> BAB
 */


import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int max = 0;
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int m;
    static int n;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());  // 열
        n = Integer.parseInt(st.nextToken());  // 행

        /*
        1 : 익은 토마토
        0 : 익지 않은 토마토
        -1 : 토마토 없음
         */
        visited = new boolean[n][m];
        int[][] arr = new int[n][m];
        int count = 0;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if (arr[i][j] == 1) {
                    list.add(new int[]{i,j,0});
                }
            }
        }
        bfs(list,arr);
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if (arr[i][j] == 0) {
                    flag = true;
                    break;
                }
            }
            if(flag)
                break;
        }
        if(flag){
            System.out.println(-1);
        }else {
            System.out.println(max);
        }

        /*
        1. 원래 전부다 1 -1이면 0출력
        2. 모두 익지 못하는 상황 -1출력
         */
//        for(int i=0; i<n; i++){
//            for(int j=0; j<m; j++){
//                if (arr[i][j] == 0) {
//                    sb.append(-1);
//                }
//            }
//        }

    }

    public static void bfs(ArrayList<int[]> list, int[][] arr) {
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<list.size(); i++){
            q.offer(list.get(i)); // 첫번 재 열  두번쨰 행
            visited[list.get(i)[0]][list.get(i)[1]] = true;
        }
        while(!q.isEmpty()){
            int[] cur = q.poll();
            max = Math.max(max, cur[2]);
            for(int k=0;k<4;k++){
                int x = cur[1] + dx[k]; // 열
                int y = cur[0] + dy[k]; // 행

                if(x<0 || x>m-1 || y<0 || y>n-1) // 범위 벗어남
                    continue;

                if(visited[y][x]) // 이미 들림
                    continue;
                if(arr[y][x] == 0){
                    q.offer(new int[]{y, x,cur[2]+1});
                    arr[y][x] = 1;
                    visited[y][x] = true;
                }
            }
        }

    }
}


