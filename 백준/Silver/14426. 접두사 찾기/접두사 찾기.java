import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int result = 0;
        TrieNode rootNode = new TrieNode();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++) {
            rootNode.insert(br.readLine());
        }
        for(int i=0; i<m; i++) {
            if(rootNode.search(br.readLine())) {
                result++;
            }
        }
        System.out.println(result);
    }
}


class TrieNode{
    HashMap<Character, TrieNode> children;
    boolean isEnd;

    TrieNode(){
        children = new HashMap<>();
        isEnd = false;
    }
    void insert(String str){
        TrieNode curNode = this;
        char[] charArray = str.toCharArray();
        for(int i=0; i<charArray.length; i++){
            curNode.children.putIfAbsent(charArray[i], new TrieNode());
            curNode = curNode.children.get(charArray[i]);
        }
        curNode.isEnd = true;
    }

    boolean search(String str){
        TrieNode curNode = this;
        char[] charArray = str.toCharArray();
        for(int i=0; i<charArray.length; i++){
            if(!curNode.children.containsKey(charArray[i])){
                return false;
            }
            curNode = curNode.children.get(charArray[i]);

        }
        return true;
    }

}