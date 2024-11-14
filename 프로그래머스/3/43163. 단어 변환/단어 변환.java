import java.util.*;
import java.io.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visited = new boolean[words.length];
        
        int[] record = new int[words.length];
        
        Queue<String> q = new LinkedList<>();
        q.offer(begin);
        
        while(q.size()!=0){
            String cur = q.poll();
            
            for(int i=0; i<words.length; i++){
                if(cur.equals(target)){
                    return record[findcur(cur,words)];
                }
                if(!find(cur,words[i]))
                    continue;
                if(visited[i])
                    continue;
                
                q.offer(words[i]);
                visited[i] = true;
                int u = findIndex(cur,words);
                record[i] = record[u]+1;
                // System.out.println(words[i]);
                // System.out.println(record[i]);
                
                
            }
            
        }
        
        
        
        return answer;
    }
    
    
    
    
    
    
    
    
    public static boolean find(String s1, String s2){
        int dif = 0;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) dif++;
        }
        if(dif==1) return true;
        return false;
    }
    public static int findIndex(String s1, String[] s2){
        
        for(int i=0; i<s2.length; i++){
            if(s1.equals(s2[i])) return i;
        }
        return 0;
    }
    public static int findcur(String s1, String[] s2){
        for(int i=0; i<s2.length; i++){
            if(s1.equals(s2[i])) return i;
        }
        return 0;
    }
    
    

}