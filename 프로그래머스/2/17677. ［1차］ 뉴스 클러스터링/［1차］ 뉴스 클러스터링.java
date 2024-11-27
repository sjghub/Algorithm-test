import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        int minCount = 0;
        int maxCount = 0;
        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();

        for(int i=0; i<str1.length()-1; i++){
            String currentS = str1.substring(i,i+2);
            
            if(!validate(currentS))
                continue;
            currentS = currentS.toLowerCase();
            map1.put(currentS,map1.getOrDefault(currentS,0)+1);

        }
        for(int i=0; i<str2.length()-1; i++){
            String currentS = str2.substring(i,i+2);
            
            if(!validate(currentS))
                continue;
            currentS = currentS.toLowerCase();
            map2.put(currentS,map2.getOrDefault(currentS,0)+1);

        }


        Iterator<String> iterator1 = map1.keySet().iterator();
        


        while(iterator1.hasNext()){
            String ke = iterator1.next();
            
            maxCount += Math.max(map1.get(ke),map2.getOrDefault(ke,0));
            
            minCount += Math.min(map1.get(ke),map2.getOrDefault(ke,0));
           

        }
        Iterator<String> iterator2 = map2.keySet().iterator();
        while(iterator2.hasNext()){
            String ke = iterator2.next();
            if(!map1.containsKey(ke)){
                maxCount += map2.get(ke);
            }
            // minCount += Math.min(map1.getOrDefault(ke,0),map2.get(ke));
            
            
        }

        System.out.println(minCount);
        System.out.println(maxCount);


        return print(minCount,maxCount);
    }
    public static boolean validate(String currentS){
        if(currentS.matches("[a-zA-Z][a-zA-Z]")){
            return true;
        }
        return false;
    }
    public static int print(int minCount, int maxCount){
        if(maxCount == 0){
            return 65536;
        }
        double d = (double)minCount/(double)maxCount; 
        return (int) Math.floor(d*65536);
    }
}