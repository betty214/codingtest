package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_14500{
    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };
    static int max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                DFS(i, j, 0, 0);
                Exception(i, j);
            }
        }
        System.out.println(max);
    }
    public static void DFS(int x, int y, int depth, int sum) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];
            if(check(cx,cy)){
                if(!visited[cx][cy]){
                    visited[cx][cy] = true;
                    DFS(cx, cy, depth + 1, sum + arr[cx][cy]);
                    visited[cx][cy] = false;
                }
            }
        }
    }
    public static void Exception(int x, int y) {
        int wing = 4;
        int min = Integer.MAX_VALUE;
        int sum = arr[x][y];
        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];
            if (wing < 3)
                return;
            if(!check(cx,cy)){
                wing--;
            }else{
                min = Math.min(min, arr[cx][cy]);
                sum += arr[cx][cy];
            }
        }
        if (wing == 4) {
            sum -=min;
        }
        max = Math.max(max, sum);
    }
    static boolean check(int x,int y){
        if(x<0||y<0||x>=N||y>=M){
            return false;
        }else{
            return true;
        }
    }
}