
class Solution {
    public int[] solution(String s) {
        int[] answer = {0,0};
        String cps = s;
        int cnt;
        while(!cps.equals("1")){
            cnt=0;
            for(int i=0; i<cps.length(); i++){
                if(cps.charAt(i) == '1')
                    cnt++;
            }
            answer[0] += 1;
            answer[1] += cps.length()-cnt;
            cps=Integer.toBinaryString(cnt);
        }
        
        
        return answer;
    }
}