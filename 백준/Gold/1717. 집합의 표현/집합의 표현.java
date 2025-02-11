import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        HashMap<String, Boolean> map = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        for(int i=0;i<N+1;i++)
            arr[i] = i;

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int third = Integer.parseInt(st.nextToken());
            if(first==0){
                //union
                union(second,third);
            }
            else{
                //find
                int a = find(second);
                int b = find(third);
                if(a==b)
                    sb.append("YES\n");
                else
                    sb.append("NO\n");
            }
        }
        System.out.println(sb.toString());


    }
    static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if(fa!=fb) arr[fa]=fb;
    }
    static int find(int v){
        if(v==arr[v]){
            return v;
        }
        return arr[v] = find(arr[v]);
    }

}
