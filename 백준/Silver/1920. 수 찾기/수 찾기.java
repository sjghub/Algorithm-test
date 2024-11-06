import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr1 = new int[n];
        for(int i = 0; i<n;i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);
        
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr2 = new int[m];
        for(int i=0; i<m; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<arr2.length; i++){
            sb.append(even(arr2[i],0,n-1,arr1)).append("\n");
        }
        System.out.print(sb);
        
        
      
    }
    public static int even(int target, int low, int high, int[] arr){
        int mid;
        while(low<=high){
            mid = (low+high)/2;
            if(target == arr[mid])
                return 1;
            if(target > arr[mid]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return 0;
        
        
        
    }
}