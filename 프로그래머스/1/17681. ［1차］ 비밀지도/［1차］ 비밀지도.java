class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String s1;
        String s2;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            s1 = padLeft(n, Integer.toBinaryString(arr1[i]));
            s2 = padLeft(n, Integer.toBinaryString(arr2[i]));
            
            sb = new StringBuilder();
            for(int j=0; j<n; j++){
                if(s1.charAt(j) == '0' && s2.charAt(j) == '0')
                    sb.append(' ');
                else
                    sb.append('#');
            }
            
            answer[i] = sb.toString();
            
            
        }
        return answer;
    }
    public String padLeft(int length, String s){
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - s.length()) {
            sb.append('0');
        }
        sb.append(s);
        return sb.toString();
    }
    
}