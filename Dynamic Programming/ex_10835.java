package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex_10835 {
    static int N;
    static int[]left_arr,right_arr;
    static int[][]DP;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        left_arr=new int[N];
        right_arr=new int[N];
        DP=new int[N][N];
        for(int i=0; i<N; i++){
            Arrays.fill(DP[i], -1);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            left_arr[i]=Integer.parseInt(st.nextToken());
        }st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            right_arr[i]=Integer.parseInt(st.nextToken());
        }
        System.out.println(DFS(0,0));
    }
    static int DFS(int left, int right) {
        if(left == N || right == N) {
            return 0;
        }
        if(DP[left][right] != -1)
            return DP[left][right];

        DP[left][right] = Math.max(DFS(left+1, right+1),DFS(left+1, right));
        if(left_arr[left] > right_arr[right]){
            DP[left][right] = Math.max(DP[left][right], DFS(left, right+1) + right_arr[right]);
        }
        return DP[left][right];
    }
}
