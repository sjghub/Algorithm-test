import java.util.*;
import java.io.*;
class Solution {
    static int answer=0;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        
        
        
        visited = new boolean[dungeons.length];
            
        dfs(0,k,dungeons);
            
        
        
        // System.out.println(answer);
        return answer;
    }
    public static void dfs(int count,int currentK,int[][] dungeons){
        answer = Math.max(answer,count);
        
        for(int j=0; j<dungeons.length; j++){
            if(visited[j]|| currentK < dungeons[j][0])
                continue;
            visited[j] = true;
            dfs(count+1,currentK - dungeons[j][1],dungeons);
            visited[j] = false;
            
        }
        
    }
}

