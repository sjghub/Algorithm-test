import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String,Double> map = new TreeMap<>();
        double total = 0;
        String input;
        while((input = br.readLine())!=null){
            map.put(input,map.getOrDefault(input,0.0)+1.0);
            total+=1.0;
        }
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Double> entry : map.entrySet()){
            double curNumber =  entry.getValue();
            double percent = curNumber/total*100;
            sb.append(entry.getKey()).append(" ").append(String.format("%.4f",percent)).append("\n");
        }
        System.out.println(sb);
    }
}

