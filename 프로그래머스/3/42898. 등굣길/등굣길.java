import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[n+1][m+1];  //n = 3, m = 4
        boolean[][] no = new boolean[n+1][m+1];
        for(int i=0; i<puddles.length; i++){
            no[puddles[i][1]][puddles[i][0]] = true;
        }
        for(int i=1;i<n+1; i++){
            for( int j = 1; j<m+1; j++){
                if(no[i][j]){
                    continue;
                }
                if(i == 1 && j == 1){
                    map[i][j] = 1;
                    continue;
                }
                if(no[i-1][j]) map[i][j] += map[i][j-1]%1000000007;
                else if(no[i][j-1]) map[i][j] += map[i-1][j]%1000000007;
                else map[i][j]+= map[i-1][j]%1000000007+map[i][j-1]%1000000007;
            }
        }
        answer = map[n][m]%1000000007;
        return answer;
    }
}