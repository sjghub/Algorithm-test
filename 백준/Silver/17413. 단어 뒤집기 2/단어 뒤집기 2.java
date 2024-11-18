
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
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '<'){
                print(stack);
                int curIndex = atIsPrint(s, i);
                i = curIndex;
            }else if(s.charAt(i) == ' '){
                print(stack);
                sb.append(' ');
            }else{
                reversePrint(stack,s, i);
            }
        }
        print(stack);
        System.out.println(sb);
    }

    public static int atIsPrint(String s, int i) {
        int plusIndex = 0;
        while(s.charAt(i+plusIndex) != '>'){
            sb.append(s.charAt(i + plusIndex));
            plusIndex++;
        }
        sb.append(s.charAt(i + plusIndex));
        return i+plusIndex;
    }

    public static void reversePrint(Stack<Character> stack,String s, int i) {
        stack.add(s.charAt(i));
    }

    public static void print(Stack<Character> stack) {
        while(!stack.empty()){
            sb.append(stack.pop());
        }
    }
}