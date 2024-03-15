class Solution {
    public int solution(int n) {
        if(n==1) return 2;
        int answer = 0;
        int m = n;
        boolean flag = true;
        answer = ConvertDemical(n);
        while(flag){
            m+=1;
            if(answer==ConvertDemical(m))
                break;
        }
        return m;
    }
    public int ConvertDemical(int num){
        int cnt = 0;
        int share = num;
        int remainder = 0;
        while(share>1){
            remainder = share % 2;
            share = share / 2;
            if(remainder == 1)
                cnt++;
        }
        return cnt+1;
    }
    
}


// 1 n의 다음 큰 숫자 =m
// 2. convert n to 2진수 의 1의 갯수 = convert m to 2진수 의 1의 갯수 
//  > 2진수 변환기 만들자
// 3. 1,2를 만족시키는 수중 min
