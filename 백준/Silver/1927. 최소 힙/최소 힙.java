
/**
 * 1. 푸는 방법 둘중 짧은 것을 픽
 * <p>
 * 그 문자의 길이부터 부분문자열을 잘라서 다른 문자열이 그 부분문자열을 포함하고있는지 확인 3. 자료구조
 * <p>
 * <p>
 * 1. A 2. A+A  , A+B -> B+A 3. AAA, A+A+B -> BAA , BAA, BAB -> BAB
 */


import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            long value = Long.parseLong(br.readLine());
            if(value == 0){

                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                }else{
                    long c = pq.poll();
                    sb.append(c).append("\n");
                }
            }else{
                pq.offer(value);
            }
        }
        System.out.print(sb);

    }

}


