package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex_1912 {
    static int [] DP,array;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        array=new int[N];
        DP=new int[N];
        Arrays.fill(DP,-1001);
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        DP[0] = array[0];
        max = array[0];
        DFS(N - 1);
        System.out.println(max);
    }
    static int DFS(int n) {
        if(DP[n] == -1001) {
            DP[n] = Math.max(DFS( n- 1) + array[n], array[n]);
            max = Math.max(DP[n], max);
        }

        return DP[n];
    }
}
