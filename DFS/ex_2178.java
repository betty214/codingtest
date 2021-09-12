package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ex_2178 {
    static int N,M,count;
    static int []dx={1,-1,0,0};
    static int []dy={0,0,1,-1};
    static int [][]maze;
    static boolean[][]visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        maze=new int[N][M];
        visited=new boolean[N][M];
        for(int i=0;i<N;i++){
            String input = br.readLine();
            for(int j=0;j<input.length();j++){
                maze[i][j]=Character.getNumericValue(input.charAt(j));
            }
        }
        BFS(0,0);
        System.out.println(maze[N-1][M-1]);
    }
    static void BFS(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x,y});

        while(!q.isEmpty()){
            int location[] = q.poll();
            visited[x][y] = true;
            for(int i=0;i<4;i++){
                int cx=location[0]+dx[i];
                int cy=location[1]+dy[i];
                if(check(cx,cy)){
                    if(maze[cx][cy] == 1 && !visited[cx][cy]){
                        q.offer(new int[] {cx,cy});
                        visited[cx][cy] = true;
                        maze[cx][cy] = maze[location[0]][location[1]] + 1;
                    }
                }
            }
        }
    }static boolean check(int x,int y){
        if(x<0||y<0||x>=N||y>=M){
            return false;
        }else{
            return true;
        }
    }
}
