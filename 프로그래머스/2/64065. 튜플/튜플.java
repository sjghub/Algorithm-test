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
         Set<String> set = new HashSet<>();
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.sort(arr, (a, b)->{return a.length() - b.length();});
        int[] answer = new int[arr.length];
        int idx = 0;
        for(String s1 : arr) {
            for(String s2 : s1.split(",")) {
                if(set.add(s2)) answer[idx++] = Integer.parseInt(s2);
            }
        }
        return answer;
    }
}