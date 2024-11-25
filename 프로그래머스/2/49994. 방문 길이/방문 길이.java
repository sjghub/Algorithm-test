/*
1. 푸는 방법
현재 점을 방문 표시하고 다음 점으로 이동후 방문표시
현재 점이 방문 되어있고 다음 점이 방문표시가 안되어 있으면 count
조건에 의해 다음점 이동이 안되면 명령 무시
*/
import java.util.*;
import java.io.*;
class Solution {
    public int solution(String dirs) {
        int answer = 0;

        
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        

        
        int currentX = 5;
        int currentY = 5;

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
       
        
        Set<String> xy = new HashSet<>();
        for(int i=0; i<dirs.length(); i++){
            StringBuilder sb = new StringBuilder();
            Character c = dirs.charAt(i);
            int index = calculateNextDot(c);
            int nextX = dx[index]+currentX;
            int nextY = dy[index]+currentY;
            
            
            if(nextX>10 || nextX<0 || nextY>10 || nextY<0)
                continue;
            
            
            xy.add(setKey1(currentX,currentY,nextX,nextY));
            xy.add(setKey2(currentX,currentY,nextX,nextY));
            currentX = nextX;
            currentY = nextY;
            
        }
        
        
        
        
        return xy.size()/2;
    }
    public static int calculateNextDot(Character c){
        if(c == 'L')
            return 0;
        if(c == 'R')
            return 1;
        if(c == 'D')
            return 2;
        return 3;
        
    }
    public static String setKey1(int cx, int cy, int nx, int ny){
        StringBuilder sb = new StringBuilder();
        return sb.append(cx).append(" ").append(cy).append(" ").append(nx).append(" ").append(ny).toString();
        
    }
    public static String setKey2(int cx, int cy, int nx, int ny){
        StringBuilder sb = new StringBuilder();
        return sb.append(nx).append(" ").append(ny).append(" ").append(cx).append(" ").append(cy).toString();
        
    }
}


   
