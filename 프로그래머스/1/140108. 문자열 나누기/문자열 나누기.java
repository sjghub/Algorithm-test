class Solution {
    public int solution(String s) {
        int answer = 0;
        int same = 1;
        int diff = 0;
        boolean flag = false;
        if(s.length() == 1) return 1;
        
        char x = s.charAt(0);
        for(int i = 1; i<s.length(); i++){
            if(flag){
                x=s.charAt(i);
                flag=false;
            }    
            if(x == s.charAt(i)){
                same++;
            }else{
                diff++;
            }
            
            if(same == diff){
                answer++;
                flag=true;
                same=0;
                diff=0;
            }
            
            
        }
        if(same!=0 || diff != 0) answer++;
        return answer;
    }
}