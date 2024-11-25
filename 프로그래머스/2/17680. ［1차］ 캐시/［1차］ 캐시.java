
/**
 * 1. 푸는 방법 list에 size()가 n보다 작으면 넣는다. hashmap에도 넣는다 n이상이면 만약 hashmap에 있으면 map은 그대로 두고 list에서 그 단어가 등장하는 첫번 쨰 인덱스를 구하고 그
 * 인덱스를 제거하고 마지막에 그 단어 추가 +1 없으면 list 첫번 째 원소 빼고 마지막에 add , map에서도 list 첫번째 원소 뺴고 마지막꺼 put + 5 3. 자료구조 n * 30
 */
import java.io.*;
import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        if(cacheSize == 0)
            return cities.length*5;
        String[] real = new String[cities.length];
        for(int i=0; i<real.length; i++)
            real[i] = cities[i].toLowerCase();
        
        for (int i = 0; i < real.length; i++) {
            if (map.containsKey(real[i])) {
                list.remove(real[i]);
                list.add(real[i]);
                answer += 1;
            } else {
                if (list.size() < cacheSize) {
                    list.add(real[i]);
                } else {
                    String s = list.remove(0);
                    map.remove(s);
                    list.add(real[i]);
                }
                map.put(real[i], 1);
                answer += 5;

            }
        }
        return answer;

    }
}
