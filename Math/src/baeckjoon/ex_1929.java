package baeckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex_1929 {
    static int M,N;
    static boolean[] isPrime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        isPrime=new boolean[N+1];
        Arrays.fill(isPrime,true);
        isPrime[1]=false;
        prime();
        for(int i=M;i<=N;i++){
            if(isPrime[i]){
                System.out.println(i);
            }
        }
    }static void prime(){
        for(int i=2;i<=Math.sqrt(N);i++){
            for(int j=2;j<=N;j++){
                if(isPrime[j]&&j%i==0&&j!=i){
                    isPrime[j]=false;
                }
            }
        }
    }
}
