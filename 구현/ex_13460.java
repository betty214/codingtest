package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ex_13460 {
    static int N,M,goal_x,goal_y;
    static char [][]board;
    static boolean[][][][]visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Marble blue, red;
    private static class Marble {
        int rx;
        int ry;
        int bx;
        int by;
        int cnt;

        public Marble(int rx, int ry, int bx, int by, int cnt) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board=new char[N][M];
        visited=new boolean[N][M][N][M];
        for(int i=0;i<N;i++){
            String input = br.readLine();
            for(int j=0;j<M;j++){
                board[i][j]=input.charAt(j);
                if(board[i][j]=='O'){
                    goal_x=i;
                    goal_y=j;
                }if(board[i][j]=='B') {
                    blue = new Marble(0, 0, i, j, 0);
                }if(board[i][j]=='R') {
                    red = new Marble(i, j, 0, 0, 0);
                }
            }
        }
        System.out.println(bfs());
    }
    public static int bfs() {
        Queue<Marble> queue = new LinkedList<>();
        queue.add(new Marble(red.rx, red.ry, blue.bx, blue.by, 1));
        visited[red.rx][red.ry][blue.rx][blue.ry] = true;

        while (!queue.isEmpty()) {
            Marble marble = queue.poll();
            int curRx = marble.rx;
            int curRy = marble.ry;
            int curBx = marble.bx;
            int curBy = marble.by;
            int curCnt = marble.cnt;

            if (curCnt > 10) {
                return -1;
            }

            for (int i = 0; i < 4; i++) {
                int newRx = curRx;
                int newRy = curRy;
                int newBx = curBx;
                int newBy = curBy;

                boolean isRedHole = false;
                boolean isBlueHole = false;

                while (board[newRx + dx[i]][newRy + dy[i]] != '#') {
                    newRx += dx[i];
                    newRy += dy[i];
                    if (newRx == goal_x && newRy == goal_y) {
                        isRedHole = true;
                        break;
                    }
                }
                while (board[newBx + dx[i]][newBy + dy[i]] != '#') {
                    newBx += dx[i];
                    newBy += dy[i];
                    if (newBx == goal_x && newBy == goal_y) {
                        isBlueHole = true;
                        break;
                    }
                }

                if (isBlueHole) {
                    continue;
                }
                if (isRedHole && !isBlueHole) {
                    return curCnt;
                }

                if (newRx == newBx && newRy == newBy) {
                    if (i == 0) {
                        if (curRx > curBx) newRx -= dx[i];
                        else newBx -= dx[i];
                    } else if (i == 1) {
                        if (curRy < curBy) newRy -= dy[i];
                        else newBy -= dy[i];
                    } else if (i == 2) {
                        if (curRx < curBx) newRx -= dx[i];
                        else newBx -= dx[i];
                    } else {
                        if (curRy > curBy) newRy -= dy[i];
                        else newBy -= dy[i];
                    }
                }

                if (!visited[newRx][newRy][newBx][newBy]) {
                    visited[newRx][newRy][newBx][newBy] = true;
                    queue.add(new Marble(newRx, newRy, newBx, newBy, curCnt + 1));
                }
            }
        }
        return -1;
    }
}
