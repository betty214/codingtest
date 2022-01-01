package backjun;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ex_2665{
    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n;
    static int[][] board;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        count = new int[n][n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            String temp=st.nextToken();
            for(int j = 0; j < n; j++) {
                board[i][j] = temp.charAt(j) - '0';
            }Arrays.fill(count[i],Integer.MAX_VALUE);
        }
        dijkstra();
        System.out.println(count[n - 1][n - 1]);
    }static void dijkstra() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));
        count[0][0] = 0;

        while(!q.isEmpty()) {
            Node now = q.poll();
            for(int i = 0; i < 4; i++) {
                int cx = now.x + dx[i];
                int cy = now.y + dy[i];
                if(check(cx,cy)){
                    if(count[cx][cy] > count[now.x][now.y]) {
                        if(board[cx][cy] == 1) {
                            count[cx][cy] = count[now.x][now.y];
                        }else {
                            count[cx][cy] = count[now.x][now.y]+1;
                        }
                        q.offer(new Node(cx, cy));
                    }
                }
            }
        }
    }static boolean check(int x, int y ){
        if(x<0||y<0||x>=n||y>=n){
            return false;
        }else{
            return true;
        }
    }
}
