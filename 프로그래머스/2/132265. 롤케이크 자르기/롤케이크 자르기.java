import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        if(topping.length == 1)
            return answer;
//         if(topping.length == 2){
//             if(topping[0] == topping[1])
//                 return answer+1;
//         }
        
        
        HashMap<Integer,Integer> left = new HashMap<>();
        HashMap<Integer,Integer> right = new HashMap<>();
        
        left.put(topping[0],1);
        for(int i=1; i<topping.length; i++){
            if(right.containsKey(topping[i])){
                right.put(topping[i],right.get(topping[i])+1);
            }else{
                right.put(topping[i],1);
            }
        }  // 10^^6
        
        if(left.size() == right.size())
            answer++;
        
        for(int i=1; i<topping.length; i++){
            int key = topping[i];
            if(!left.containsKey(key)){
                left.put(key,1);
            }
            right.put(key,right.get(key)-1);
            if(right.get(key) == 0)
                right.remove(key);
            if(left.size() == right.size())
                answer++;
        }
        
        
        return answer;
    }
}


// 절반부터 쭉 자르는거
// 짜른거 양옆에 종류세는 거