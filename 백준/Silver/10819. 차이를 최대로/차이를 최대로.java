import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.*;
public class Main{
    static int[] record;
    static int[] arr;
    static boolean[] visited;
    static int[][] boo;
    static int a;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        record = new int[n];
        visited = new boolean[n];

        boo = new int[ff(n)][n];
        permutation(n,0);
        int max = 0;
        for(int i=0; i<ff(n); i++){
            max = Math.max(max,difSum(boo[i]));

        }
        System.out.println(max);

    }


    public static void permutation(int n, int depth){
        if(depth == n){
            for(int i=0; i<n; i++){
                boo[a][i] = record[i];
            }
            a++;
            return ;
        }

        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                record[depth] = arr[i];
                permutation(n,depth+1);
                visited[i] = false;
            }
        }

    }
    public static int difSum(int[] arr1){
        int sum =0;
        for(int i=0; i<arr1.length-1; i++){
            if(arr1[i]>=arr1[i+1]){
                sum+= arr1[i]-arr1[i+1];
            }else{
                sum+= arr1[i+1]-arr1[i];
            }
        }
        return sum;
    }
    public static int factorial(int n){
        if(n == 1) return 1;

        return n*factorial(n-1);
    }
    public static int ff(int n){
        int[] arr1 = new int[n];
        arr1[0] = 1;
        for(int i=0; i<n-1; i++){
            arr1[i+1] = arr1[i]*(i+2);
        }
        
        
        return arr1[n-1];
    }
}

