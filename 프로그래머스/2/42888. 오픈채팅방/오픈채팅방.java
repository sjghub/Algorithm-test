/*
1.푸는 방법
처음 record를 돌면서 enter로 시작되면 map에 유저아디,유저네임을 적는다.
change면 유저아디에 맞는 value값을 바꾼다.

다음 다시 record를 돌면서 enter로 시작하면 그의 유저아디에 맞는 value+님이 들어왔습니다 add
leave로 시작하면 그의 유저아디에 맞는 value+님이 나갔습니다. add


*/
import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        Map<String,String> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        
        for(String s : record){
            if(s.startsWith("Enter") || s.startsWith("Change")){
                String[] ss = s.split(" ");
                map.put(ss[1],ss[2]);
            }
        }
        for(String s : record){
            String[] ss = s.split(" ");
            if(s.startsWith("Enter")){
                list.add(map.get(ss[1])+"님이 들어왔습니다.");
            }else if(s.startsWith("Leave")){
                list.add(map.get(ss[1])+"님이 나갔습니다.");
            }
        }
        String[] answer = new String[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}