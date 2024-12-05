import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(skill.length() == 1) return skill_trees.length;
        for(int i=0; i<26; i++){
            list.add(new ArrayList<Integer>());
        }
        for(int i=1; i<skill.length(); i++){
            list.get(skill.charAt(i)-'A').add(skill.charAt(i-1)-'A');
        }
        
        for(int i=0; i<skill_trees.length; i++){
            boolean[] visited = new boolean[26];
            String s = skill_trees[i];
            
            for(int j=0; j<s.length(); j++){
                if(list.get(s.charAt(j)-'A').isEmpty()){
                    visited[s.charAt(j)-'A']=true;
                    continue;
                }
                int pre = list.get(s.charAt(j)-'A').get(0);
                if(!visited[pre]){
                    answer-=1;
                    break;
                }
                visited[s.charAt(j)-'A'] = true;
            }
        }
        return answer;
    }
}