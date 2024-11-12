import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.*;
public class Main{
    StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] xy = new int[m][4];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++){
                xy[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<n; i++){
            for(int j=1; j<n; j++){
                arr[i][j]+=arr[i][j-1];
            }
        }
        
        for (int j = 0; j < m; j++) {
            long sum = 0;
            int x1 = xy[j][0];
            int y1 = xy[j][1];
            int x2 = xy[j][2];
            int y2 = xy[j][3];
            for (int i = x1-1; i < x2; i++) {
                sum += arr[i][y2 - 1];
            }
            for (int i = x1-1; i < x2; i++) {
                int y = y1-2;
                if(y<0) continue;
                sum -= arr[i][y];
            }

            System.out.println(sum);
        }
       
        
        
        /*
        행:0~x2-1 열 :y2-1 - 행 :0~x1-1 열 : y2-1  -   행 :x1-1~x2-1  열: y1-1
        
        
        (1,1)
        */
        
    }
}

