package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ex_2422 {
    static int count,N;
    static boolean[][]ice;
    static boolean[]visited;
    static int[] data = new int[3];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        ice = new boolean[N + 1][N + 1];
        count=0;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int first= Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            ice[first][second]=true;
            ice[second][first]=true;
        }
        comb(0, 1);
        System.out.println(count);
    }static void comb(int depth, int start){
        if(depth==3){
            boolean flag=false;
            for (int i = 0; i < 2; i++) {
                for (int j = i + 1; j < 3; j++) {
                    if (ice[data[i]][data[j]] == true){
                        flag=true;
                        break;
                    }
                }
            }
            if(!flag){
                count++;
            }
            return;
        }
        for (int i = start; i < N + 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                data[depth] = i;
                comb(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}
