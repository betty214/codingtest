package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ex_1103 {
    static int N,M,answer;
    static int[][]board,DP;
    static boolean[][]visited;
    static boolean flag;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static private class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/input/1103.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N =Integer.parseInt(st.nextToken());
        M =Integer.parseInt(st.nextToken());
        board=new int[N][M];
        DP=new int[N][M];
        visited=new boolean[N][M];
        flag=false;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String now = st.nextToken();
            for(int j=0;j<M;j++){
                if(now.charAt(j)=='H')board[i][j]=-1;
                else board[i][j]=Integer.parseInt(now.substring(j,j+1));
            }
        }
        visited[0][0]=true;
        dfs(0,0,1);
        if(!flag) System.out.println(answer);
        else System.out.println(-1);
    }
    static boolean check(int x, int y){
        if(x<0||y<0||x>=N||y>=M) return false;
        if(board[x][y]==-1) return false;
        return true;
    }
    static void dfs(int x, int y, int cnt) {
        answer=Math.max(answer,cnt);
        DP[x][y] = cnt;
        for (int i = 0; i < 4; i++) {
            int num = board[x][y];
            int cx = dy[i] * num + x;
            int cy = dx[i] * num + y;
            if (check(cx,cy)){
                if (visited[cx][cy]) {
                    flag = true;
                    return;
                }
                if (DP[cx][cy] > cnt) continue;
                visited[cx][cy] = true;
                dfs(cx, cy, cnt+1);
                visited[cx][cy] = false;
            }
        }
    }
}