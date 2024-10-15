import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;
public class Main {
    static BufferedReader br;
    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());


        int[] arr = new int[n];
        int cnt = 0;
        // br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            arr[cnt++] = Integer.parseInt(st.nextToken());
        }
        // for(int i=0; i<n; i++){
        //     arr[i] = Integer.parseInt(st.nextToken());
        // }
        // Arrays.sort(arr);
        int answer = 0;
        for(int i=0; i<n-1; i++){
            if(m<=arr[i]) continue;
            for(int j=i+1; j<n; j++){
                if(arr[i]+arr[j] == m){
                    answer++;
                }  
            }
        }
        System.out.print(answer);
    }
}
