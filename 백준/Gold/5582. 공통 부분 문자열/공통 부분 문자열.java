
/**
 1. 푸는 방법
 둘중 짧은 것을 픽

 그 문자의 길이부터 부분문자열을 잘라서 다른 문자열이 그 부분문자열을
 포함하고있는지 확인
 3. 자료구조


 1. A
 2. A+A  , A+B -> B+A
 3. AAA, A+A+B -> BAA , BAA, BAB -> BAB
 */
import com.sun.source.tree.Tree;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i < s1.length(); i++) {
            for(int j=0; j< s2.length(); j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j]+1;
                    answer = Math.max(answer,dp[i+1][j+1]);
                }
            }
        }
        System.out.println(answer);
    }



}


