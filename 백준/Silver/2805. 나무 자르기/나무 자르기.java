import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int max = 0;
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        System.out.print(even(arr,max,m));



    }
    public static int even(int[] arr,int max,int get){
        int lo = 0;
        int hi = max;
        while(lo<=hi){
            int mid = (hi+lo)/2;
            long c = count(arr,mid);
            if(c>=get){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        return hi;
    }
    public static long count(int[] arr,int length){
        long count = 0;
        for (int j : arr) {
            if (j > length) {
                count += j - length;
            }

        }
        return count;
    }
}

/*
1. 주어진 것들중 최고 길이를 구함
2. 최고 길이를 이진탐색
A. 이진탐색해서 나온 값으로 짜른다 반복
B. ARR를 순회하면서 짤라서 몫이 1이상인 것들 중 나머지를 모두 더한다.
C. 나머지가 M이상일 경우 멈춘다.
*/