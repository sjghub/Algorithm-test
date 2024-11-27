/*
1.푸는 방법
"},{" 기준으로 분할 = Strings[]
    -> if Strings[] 크기가 1이면 앞에 2개 뒤에 2개 짜르고 반환
Strings[]의 첫밴쨰 원소 앞에 2개 짜르고 마지막 원소 뒤에 2개짜름

*/

import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        String[] arr = s.split("\\},\\{");

     
        Set<String> set = new LinkedHashSet<>();
        if(arr.length == 1){
            Integer.parseInt(arr[0].substring(2,arr[0].length()-2));
            int[] a = new int[1];
            a[0] = Integer.parseInt(arr[0].substring(2,arr[0].length()-2));
            return a;
        }
        
        arr[0] = arr[0].substring(2,arr[0].length());
        arr[arr.length-1] = arr[arr.length-1].substring(0,arr[arr.length-1].length()-2);
        Arrays.sort(arr,(s1, s2) -> Integer.compare(s1.length(), s2.length()));
        
        
        
        for(int i=0; i<arr.length; i++){
            String[] strings =arr[i].split(",");
            for(int j=0; j<strings.length; j++){
                set.add(strings[j]);
            }
        }
        int[] answer = new int[set.size()];
        Iterator<String> iterator =set.iterator();
        int idx = 0;
        while(iterator.hasNext()){
            answer[idx] = Integer.parseInt(iterator.next());
            idx++;
        }
        
        return answer;
    }
}