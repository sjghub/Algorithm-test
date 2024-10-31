import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        
        int[][] array = new int[n][2];
        
        for(int i=0; i<n; i++){
            st =  new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                array[i][0] = Integer.parseInt(st.nextToken());
                array[i][1] = Integer.parseInt(st.nextToken());
            }
        } // O(N)
        

        
        
        Arrays.sort(array, (o1,o2) -> {
            if(o1[0] == o2[0]) {return o1[1]-o2[1];}
            else{return o1[0]-o2[0];}

        });   // O(N)
        

        for(int i=0; i<n; i++){
            sb.append(array[i][0]).append(" ").append(array[i][1]);
            System.out.println(sb.toString());
            sb.setLength(0);
        }
        
    }
}
/*
1. 주어진 문자열 2차원 배열로 입력
2. x좌표 기준으로 오름차순 정리
    A. x좌표가 같으면 y좌표 오름차순 정리


1트 : 2차원 배열시 메모리 과
*/

