import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int index = 0;
        int plus = 1;
        int number = 26;
        boolean flag = false;
        List<Integer> answer = new ArrayList<>(); 
        HashMap<String,Integer> map = new HashMap<>();
        String s= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i=0; i<s.length(); i++){
            map.put(Character.toString(s.charAt(i)),i+1);
        }
        while(index<msg.length()){
            String startString = msg.substring(index,index+1);
            
            while(map.containsKey(startString)){
                plus++;
                if(index+plus>msg.length()){
                    flag = true;
                    break;
                }
                startString = msg.substring(index,index+plus);
            }
            if(flag){
                if(map.containsKey(startString))
                    answer.add(map.get(startString));
                else
                    answer.add(++number);
                break;
            }
            map.put(startString,++number); // 없는 단어 사전 추가,
            answer.add(map.get(startString.substring(0,startString.length()-1))); // 리스트에 추가
            
            
            index = index+plus-1; 
            plus = 1;
            
        }
        
        
        int[] a = new int[answer.size()];
        for(int i=0; i<answer.size(); i++)
            a[i] = answer.get(i);
        
        return a;
    }
}
//while 0 번 인덱스부터
// 문자열 w가 없을때까지 w에 추가
// 없는 문자열 찾으면 없는 문자열 w를 사전에 등록
// 없는 문자열 마지막 문자의 인덱스 i 까지 문자열을 u 라고 하고 u의 색인번호를 출력하고 i 부터 while문 시작


// while이 끝났을 때 남아있는 문자열이 사전에 없으면 문자열 크기+1 출력
// 있으면 그 색인 번호 출력