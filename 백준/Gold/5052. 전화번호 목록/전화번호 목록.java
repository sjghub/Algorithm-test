
/**
 1. 푸는 방법
 -각 테스트 케이스 별로 실행
 FOR문을 돌면서 이 번호가 map에 존재하는 s로 시작하면 no 출력
 아니면 mpa에 추가
 2.시간 복잡도
 각 케이스 -> 5E1
 총 복잡도 -> E2*E5 => 시간초과
 3. 자료구조

 */
import com.sun.source.tree.Tree;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                String s = br.readLine();

                arr[j] = s;
            }
            Arrays.sort(arr);
            for(int j=0; j<n-1; j++){
                if(arr[j+1].startsWith(arr[j])){
                    flag = true;
                    break;
                }
            }
            if (flag) {
                sb.append("NO").append("\n");
            }else{
                sb.append("YES").append("\n");

            }



        }

        System.out.print(sb);
    }
}
