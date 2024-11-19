
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
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int x = Integer.parseInt(br.readLine());

        int left = 0;
        int right = n-1;
        int count=0;
        while (left < right) {
            if(arr[left]+arr[right] > x){
                right--;
            }else if(arr[left]+arr[right] < x){
                left++;
            }else{
                count++;
                left++;
                right--;
            }
        }
        System.out.println(count);
    }


}


