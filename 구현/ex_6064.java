package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_6064 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N=Integer.parseInt(st.nextToken());
            int M=Integer.parseInt(st.nextToken());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            int g = N*M/gcd(N, M);
            while(x!=y && x<g){
                if(x<y){
                    x+=N;
                }else{
                    y+=M;
                }
            }
            if(x!=y){
                System.out.println(-1);
            }else{
                System.out.println(x);
            }
        }
    }public static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
