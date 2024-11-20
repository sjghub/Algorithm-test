
/**
 * 1. 푸는 방법
 * 일단 min을  첫 번째 도시의 주유 가격으로 둔다.
 * 다음 min이 갱신 될때까지 이동하면서 갱신되는 순간 그 도시 이전 거리 합 * min 을 sum 에 더한다.
 * 반복
 * 2. 시간 복잡도
 * e5
 * 3. 자료구조
 *  n : int
 *   sum : int
 */


import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int[] distance = new int[n];
        for(int i=1; i<n; i++){
            distance[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<n; i++){
            distance[i] += distance[i - 1];
        }

        st = new StringTokenizer(br.readLine());
        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        int minPrice = price[0];
        int j = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (price[i] < minPrice) {
                sum += (long)minPrice * (long)(distance[i]-distance[j]);
                minPrice = price[i];
                j = i;

            }
        }
        if(j != n-1){
            sum += (long)minPrice * (long)(distance[n-1]-distance[j]);
        }
        System.out.println(sum);


    }

}


