/*
처음에 1번집과 2번집의 합이 최소가 되는 것을 고른다
다음에 2개 줄을 받아와서 합이 최소가 되는 것을 고른다.
etc ) 처음 받아오는 집은 그 전집의 색깔과 같아서는 안된다.

*/

import java.io.*;
import java.util.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        accumulatedSum(n,arr);
        int min = arr[n-1][0];
        for(int i=1; i<3;i++){
            if(min>arr[n-1][i])
                min = arr[n-1][i];
        }
        System.out.println(min);
     
    
    }
    public static void accumulatedSum(int n,int[][] arr){
        for(int i=1; i<n; i++){
            arr[i][0] += Math.min(arr[i-1][1],arr[i-1][2]);
            arr[i][1] += Math.min(arr[i-1][0],arr[i-1][2]);
            arr[i][2] += Math.min(arr[i-1][0],arr[i-1][1]);
        }
    }
}