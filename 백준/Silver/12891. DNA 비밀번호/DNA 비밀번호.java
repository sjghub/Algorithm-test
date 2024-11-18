
/*
1. 아이디어
연속된 문자열 -> 투포인터
p만큼 문자열을 자르고
문자열 중 A C G T 의 갯수를 arr[0] 부터 arr[4]까지 담는다. 처음 문자 카운팅
비교 후 right+1, left -1

2. 시간복잡도
o(n) -> e6 -> 1,000,000
3. 자료구조
*/

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int sLength = Integer.parseInt(st.nextToken());
        int pLength = Integer.parseInt(st.nextToken());

        String s = br.readLine();

        st = new StringTokenizer(br.readLine());
        int[] minArr = new int[4];
        for(int i=0; i<4; i++)
            minArr[i] = Integer.parseInt(st.nextToken());

        int[] arr = new int[4];

        int left = 0;
        int right = left+pLength-1;
        StringBuilder sb = new StringBuilder(s);
        countt(sb,arr,pLength);
        int answer =0;
        sumCount(arr,minArr,answer);
        if (sumCount(arr, minArr, answer)) {
            answer++;
        }
        while(right<sLength-1){
            minusCount(arr,sb.charAt(left));
            left++;
            right++;
            plusCount(sb.charAt(right),arr);

            if (sumCount(arr, minArr, answer)) {
                answer++;
            }



        }
        System.out.print(answer);


    }
    public static void countt(StringBuilder sb, int[] arr,int pLength){
        for(int i=0;i<pLength; i++){
            if(sb.charAt(i) == 'A'){
                arr[0] += 1;
            }else if(sb.charAt(i) == 'C'){
                arr[1] += 1;
            }else if(sb.charAt(i) == 'G'){
                arr[2] += 1;
            }else{
                arr[3] += 1;
            }
        }
    }
    public static void plusCount(char c, int[] arr){
        if(c == 'A'){
            arr[0] += 1;
        }else if(c == 'C'){
            arr[1] += 1;
        }else if(c == 'G'){
            arr[2] += 1;
        }else{
            arr[3] += 1;
        }
    }
    public static boolean sumCount(int[] arr,int[] minArr,int answer){
        for(int i=0; i<4; i++){
            if(arr[i]<minArr[i])
                return false;
        }
        return true;
    }
    public static void minusCount(int[] arr,char c){
        if(c == 'A'){
            arr[0] -= 1;
        }else if(c == 'C'){
            arr[1] -= 1;
        }else if(c == 'G'){
            arr[2] -= 1;
        }else{
            arr[3] -= 1;
        }
    }
}