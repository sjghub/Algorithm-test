class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int[][] arr = new int[keymap.length][26];
        for(int i=0; i<keymap.length; i++){
            for(int j=0; j<keymap[i].length(); j++){
                if(arr[i][keymap[i].charAt(j)-'A'] == 0)
                    arr[i][keymap[i].charAt(j)-'A'] = j+1;
            }
        }
        for(int i=0; i<targets.length; i++){
            for(int j=0; j<targets[i].length(); j++){
                int cur = targets[i].charAt(j)-'A';
                int min = 101;
                for(int k=0; k<arr.length; k++){
                    if(arr[k][cur]<min && arr[k][cur] !=0)
                        min = arr[k][cur];
                }
                if(min == 101) {
                    answer[i] = -1;
                    break;
                }
                else answer[i]+=min;
            }
        }
        return answer;
    }
}