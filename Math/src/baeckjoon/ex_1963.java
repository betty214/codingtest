package baeckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ex_1963 {
    static boolean[] isPrime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        isPrime=new boolean[10000];
        Arrays.fill(isPrime,true);
        isPrime[1]=false;
        prime();
        for(int t=0;t<T;t++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int X=Integer.parseInt(st.nextToken());
            int Y=Integer.parseInt(st.nextToken());
            Queue<Integer> queue = new LinkedList<>();
            int [] DP = new int[10000];
            boolean [] visited = new boolean[10000];
            queue.add(X);
            visited[X] = true;
            while(!queue.isEmpty()) {
                int now = queue.poll();
                for(int i=0; i<4; i++) {
                    for(int j=0; j<=9; j++) {
                        if(i==0 && j==0)
                            continue;
                        int next = move(now, i, j);
                        if(isPrime[next] && !visited[next]) {
                            DP[next] = DP[now]+1;
                            visited[next] = true;
                            queue.add(next);
                        }
                    }
                }
            }
            System.out.println(DP[Y]);
        }
    }static void prime(){
        for(int i=2;i<100;i++){
            if(isPrime[i]){
                for(int j=i*i;j<10000;j+=i){
                    isPrime[j]=false;
                }
            }
        }
    }static int move(int num, int index, int next){
        StringBuilder sb = new StringBuilder(Integer.toString(num));
        sb.setCharAt(index, (char)(next+'0'));
        return Integer.parseInt(sb.toString());
    }
}
