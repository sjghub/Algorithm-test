import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static StringBuilder sb= new StringBuilder();
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            n = Integer.parseInt(br.readLine());
            greedy(1,1,"1");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    public static void greedy(int curNum, int depth, String s){
        if(n == depth){

            if(calculate(s) == 0){
                sb.append(s).append("\n");
            }
            return ;
            // 종료
        }

        greedy((curNum+1), depth+1, s+" "+(curNum+1));
        greedy((curNum+1), depth+1, s+"+"+(curNum+1));
        greedy((curNum+1), depth+1, s+"-"+(curNum+1));
    }
    public static int calculate(String s){
        s = s.replaceAll(" ","");
        Iterator<Integer> it= Arrays.stream(s.split("[+,-]"))
                .map(Integer::parseInt)
                .collect(Collectors.toList()).iterator();
        int result = it.next();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '+') {
                result += it.next();
            }else if(s.charAt(i) == '-') {
                result -= it.next();
            }
        }
        return result;
    }
}

