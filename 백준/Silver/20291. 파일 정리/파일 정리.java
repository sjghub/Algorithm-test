import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String,Integer> map = new TreeMap<>();
        for(int i=0; i<n; i++){
            String[] file = br.readLine().split("\\.");
            String fileName = file[0];
            String fileExtension = file[1];

            map.put(fileExtension,map.getOrDefault(fileExtension,0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }
        System.out.println(sb);
    }
}