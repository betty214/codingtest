package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ex_16234 {
    static int N, L, R;
    static int[][] nations;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        nations = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                nations[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer=0;
        while(iterate()){
            visited = new boolean[N][N];
            answer++;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    Queue<int[]> q = new LinkedList<>();
                    Queue<int[]> q2 = new LinkedList<>();
                    int sum = 0;
                    int count=0;
                    if (!visited[i][j]) {
                        q.add(new int[]{i, j});
                    }
                    while (!q.isEmpty()) {
                        int x = q.peek()[0];
                        int y = q.peek()[1];
                        visited[x][y] = true;
                        sum += nations[x][y];
                        count++;
                        q2.add(q.poll());
                        for (int k = 0; k < 4; k++) {
                            int cx = x + dx[k];
                            int cy = y + dy[k];
                            if (check(cx, cy)) {
                                int dist = Math.abs(nations[cx][cy] - nations[x][y]);
                                if (!visited[cx][cy] && dist >= L && dist <= R) {
                                    q.add(new int[]{cx, cy});
                                    visited[cx][cy] = true;
                                }
                            }
                        }
                    }
                    if(sum!=nations[i][j]&&q2.size()!=0){

                        while (!q2.isEmpty()) {
                            int x = q2.peek()[0];
                            int y = q2.peek()[1];
                            q2.poll();
                            nations[x][y] = (int) (sum/count);
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }
    static boolean iterate(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    int cx = i + dx[k];
                    int cy = j + dy[k];
                    if (check(cx, cy)) {
                        int dist = Math.abs(nations[cx][cy] - nations[i][j]);
                        if (dist >= L && dist <= R) {
                            return true;
                        }
                    }
                }
            }
        }return false;
    }
    static boolean check(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N) {
            return false;
        } else {
            return true;
        }
    }
}
