package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_14501 {
    static int[][]work;
    static int[]DP;
    static int N;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input/14501.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        work = new int[N][2];
        DP=new int[N+1];

        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            work[i][0]=T;
            if(i+T<=N) work[i][1]=P;
        }

        for(int i=0;i<N;i++) {
            int next=i+work[i][0];
            if(next<=N){
                DP[next]=Math.max(work[i][1]+DP[i],DP[next]);
            }
            DP[i+1]=Math.max(DP[i+1],DP[i]);
        }
        for(int i=0;i<=N;i++) {
            System.out.print(DP[i]+" ");
        }
        System.out.println(DP[N]);

    }
}
