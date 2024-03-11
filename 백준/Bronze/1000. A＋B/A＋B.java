// 기본적으로 import 해야하는 패키지들
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
// 공백을 기준으로 한 줄을 나눠서 받고 싶을 때
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        System.out.println(A+B);
    }
}