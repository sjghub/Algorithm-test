import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        
        Integer[] numbersWrapper = Arrays.stream(works).boxed().toArray(Integer[]::new);
        Arrays.sort(numbersWrapper, Collections.reverseOrder());
        works = Arrays.stream(numbersWrapper).mapToInt(Integer::intValue).toArray();
        
        
        for(int i=0; i<works.length; i++){
            answer += works[i];
        }
        if(answer<=n) return 0;
        System.out.println(answer);
        long count = 0;
        int[] aa = new int[works.length];
        boolean[] visited = new boolean[works.length];
        long a = answer - n;
        while(count<a){
            for(int i=0; i<works.length; i++){
                if(visited[i])
                    continue;
                if(aa[i] == works[i])
                    visited[i] = true;
                else{
                    aa[i]+=1;
                    count++;
                }
            }
        }
        long u = count - a;
        for(int i=0; i<u; i++){
            aa[i] -=1;
        }
        long aaa = 0;
        for(int i=0; i<aa.length; i++){
            System.out.println(aa[i]);    
        }
        for(int i=0; i<aa.length; i++){
            aaa += aa[i]*aa[i];
        }
        return aaa;
    }
    
}