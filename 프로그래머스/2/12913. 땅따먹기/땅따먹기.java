

class Solution {
    int solution(int[][] land) {
        int answer = 0;

        int[][] result = new int[land.length][4];
        for(int i=0; i<4; i++){
            result[0][i] = land[0][i];
        }
        for(int i=1; i<result.length; i++){
            int zero = result[i-1][0];
            int one = result[i-1][1];
            int two = result[i-1][2];
            int three = result[i-1][3];
            result[i][0] = land[i][0]+Math.max(Math.max(one,two),three);
            result[i][1] = land[i][1]+Math.max(Math.max(zero,two),three);
            result[i][2] = land[i][2]+Math.max(Math.max(zero,one),three);
            result[i][3] = land[i][3]+Math.max(Math.max(zero,one),two);
        }
        for(int i=0; i<4; i++){
            answer = Math.max(answer, result[result.length-1][i]);
        }

        return answer;
    }
}