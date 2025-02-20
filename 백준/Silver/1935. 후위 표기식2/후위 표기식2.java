import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
//1. 시간복잡도 : n=


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[] charArray = br.readLine().toCharArray();
        double[] nums = new double[n];
        Stack<Double> stack = new Stack<>();
        for(int i=0; i<n; i++) {
            nums[i] = Double.parseDouble(br.readLine());
        }
        for(int i=0;i<charArray.length;i++){
            if(charArray[i]>='A' && charArray[i]<='Z'){
                stack.push(nums[charArray[i]-'A']);
            }else{
                double num1 = stack.pop();
                double num2 = stack.pop();
                switch(charArray[i]){
                    case '+':
                        stack.push(num2 + num1);
                        continue;
                        case '-':
                            stack.push(num2 - num1);
                            continue;
                            case '*':
                                stack.push(num2 * num1);
                                continue;
                                case '/':
                                    stack.push(num2/ num1);


                }
            }


        }
        System.out.printf("%.2f", stack.pop());


    }}


