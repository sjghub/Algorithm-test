import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int rowNum;
    static int colNum;
    static int min = 0;
    public static void main(String[] args) throws IOException {
        //dfs 방식으로 각 지역의 최단 거리를 구한다
        //list에 넣는다
        // 최소값 구하기
        ArrayList<Integer> arr = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        rowNum = Integer.parseInt(s[0]);  //세로
        colNum = Integer.parseInt(s[1]);  //가로
        map = new char[rowNum][colNum];
//        visited = new boolean[rowNum][colNum];
        for(int i=0; i<rowNum; i++){
            char[] charArray = br.readLine().toCharArray();
            for(int j=0; j<colNum; j++){
                map[i][j] = charArray[j];
            }
        }
        for(int i=0; i<rowNum; i++){
            for(int j=0; j<colNum; j++){
                if(map[i][j] == 'L')
                   bfs(i,j);
            }
        }
        System.out.println(min);
    }

    static void bfs(int i, int j){
        Queue<Node> q = new LinkedList<>();
        Node node = new Node(i, j, 0);
        boolean[][] inVisted = new boolean[rowNum][colNum];
        q.offer(node);
//        visited[i][j] = true;
        inVisted[i][j] = true;
        while(!q.isEmpty()){
            Node cur = q.poll();
            for(int k=0; k<4; k++){
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];
                if(nx>=rowNum || ny>=colNum || nx < 0 || ny < 0 || inVisted[nx][ny] || map[nx][ny] == 'W')
                    continue;
                Node node1 = new Node(nx, ny, cur.depth + 1);
                q.offer(node1);
                inVisted[nx][ny] = true;

            }
            min = Math.max(min, cur.depth);
        }

    }
}
class Node{
    int x;
    int y;
    int depth;

    Node(){
        super();
    }
    Node(int i, int j, int depth){
        super();
        this.x = i;
        this.y = j;
        this.depth = depth;
    }
}