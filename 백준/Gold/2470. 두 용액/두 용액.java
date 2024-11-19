
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
    static int max = 0;
    static boolean[] visited;
    static ArrayList<int []> tree[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        long[] print = new long[2];
        int left = 0;
        int right = n-1;
        long min = distacne(arr[left],arr[right]);
        print[0] = arr[left];
        print[1] = arr[right];
        while (left < right) {
            long sum = arr[left] + arr[right];

            if(min>Math.abs(sum)){
                min = Math.abs(sum);
                print[0] = arr[left];
                print[1] = arr[right];
                if(sum == 0) break;
            }
            if (sum < 0)
                left++;
            else {
                right--;
            }

        }
        sb.append(print[0]).append(" ").append(print[1]);
        System.out.println(sb);
    }
    public static long distacne(long a,long b){
        return Math.abs(a + b);
    }


}


