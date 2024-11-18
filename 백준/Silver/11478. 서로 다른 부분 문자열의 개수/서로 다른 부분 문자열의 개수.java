
/**
 1. 푸는 방법
 -각 테스트 케이스 별로 실행
 FOR문을 돌면서 R가 나오면 CNT +1
 D 가 나오면 IF CNT가 홀수면 배열 오른쪽끝에서 삭제
 ELSE 배열 왼쪽 끝에서 삭제
 -> 삭제시 비어있으면 에러
 마지막으로 R가 홀수면 배열 뒤집기
 아니면 원본 그대로
 2.시간 복잡도
 각 케이스 -> E5
 총 복잡도 -> E2*E5 => 시간초과
 3. 자료구조

 */
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= s.length(); i++) {
            cutString(s,i,map);
        }
        System.out.print(map.size());
    }

    public static void cutString(String s, int i, Map<String, Integer> map) {
        int left = 0;
        int right = left + i;
        for (int j = left; j <= s.length() - i; j++) {
            if(!map.containsKey(s.substring(j,j+right))){
                map.put(s.substring(j, j + right), 1);
            }
        }
    }
}