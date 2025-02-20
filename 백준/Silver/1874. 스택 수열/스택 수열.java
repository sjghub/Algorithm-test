import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        for(int i=1; i<n+1; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 1;
        for(int i=1;i<n+1;i++) {
            int cur = arr[i];
            if (stack.isEmpty()) {
                stack.push(num);
                sb.append("+\n");
                num++;
            }
            if (stack.peek() > cur) {
                System.out.println("NO");
                return;
            }
            while (stack.peek() < cur) {
                stack.push(num);
                sb.append("+\n");
                num++;
            }
            if (stack.peek() == cur) {
                stack.pop();
                sb.append("-\n");
            }


            }
        System.out.println(sb.toString());
        }



}

