import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while((line = br.readLine()) != null){
            n = Integer.parseInt(line);
            StringBuilder sb2 = new StringBuilder();
            for(int i = 0; i < Math.pow(3,n); i++){
                sb2.append("-");
            }
            sb.append(concur(sb2.toString().length(),sb2.toString())).append("\n");
        }
        System.out.println(sb.toString());
    }
    public static String concur(int curLength, String str){
        if(curLength == 1){
            return str;
        }
        String str1 = str.substring(0,curLength/3);
        String str2 = str.substring(0,curLength/3).replaceAll("-"," ");

        str = concur(curLength/3,str1) + str2 + concur(curLength/3,str1);

        return str;
    }

}

