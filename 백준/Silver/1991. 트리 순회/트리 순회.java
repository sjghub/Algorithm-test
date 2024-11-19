
/**
 * 1. 푸는 방법 둘중 짧은 것을 픽
 * <p>
 * 그 문자의 길이부터 부분문자열을 잘라서 다른 문자열이 그 부분문자열을 포함하고있는지 확인 3. 자료구조
 * <p>
 * <p>
 * 1. A 2. A+A  , A+B -> B+A 3. AAA, A+A+B -> BAA , BAA, BAB -> BAB
 */

import com.sun.source.tree.Tree;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.*;
class Node {
    char value;
    Node left;
    Node right;

    public Node(char value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class Main {
    static Node[] tree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new Node[n + 1]; // 노드 배열 생성
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char ParentValue = st.nextToken().charAt(0);
            char leftValue = st.nextToken().charAt(0);
            char rightValue = st.nextToken().charAt(0);

            if (tree[ParentValue - 'A'] == null) {
                tree[ParentValue - 'A'] = new Node(ParentValue);
            }
            if(leftValue != '.'){
                tree[leftValue - 'A'] = new Node(leftValue);
                tree[ParentValue - 'A'].left = tree[leftValue - 'A'];
            }
            if(rightValue != '.'){
                tree[rightValue - 'A'] = new Node(rightValue);
                tree[ParentValue - 'A'].right = tree[rightValue - 'A'];
            }


        }
        preOrder(tree[0]);
        sb.append("\n");
        inorder(tree[0]);
        sb.append("\n");
        postorder(tree[0]);
        System.out.println(sb);


    }

    public static void preOrder(Node node) {
        if (node == null) {
            return ;
        }
        sb.append(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        sb.append(node.value);
        inorder(node.right);
    }
    public static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        sb.append(node.value);
    }




}


