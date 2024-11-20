
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
    static boolean[] visited;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] arr = new ArrayList[n+1];
        for(int i=0; i<n+1; i++){
            arr[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }
        visited = new boolean[n + 1];
        int count = 0;
        for(int i=1; i<n+1; i++){
            if(!visited[i]){
                dfs(i,arr);
                count++;

            }
        }
        System.out.println(count);
    }
    public static void dfs(int i,ArrayList<Integer>[] arr){

        for(int j : arr[i]){
            if(!visited[j]){
                visited[j] = true;
                dfs(j,arr);
            }
        }
        return ;

    }
}


