package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex_6588 {
    static boolean p[] = new boolean[10000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        prime();
        while(N!=0){
            boolean flag=false;
            for(int i=2;i*2<=N;i++){
                if(p[i] && p[N-i]){
                    System.out.println(N+" = "+i+" + "+(N-i));
                    flag=true;
                    break;
                }
            }
            if(!flag){
                System.out.println("Goldbach's conjecture is wrong.");
            }
            N = Integer.parseInt(br.readLine());
        }
    }static void prime(){
        for(int i = 2; i <= 1000000; i++) {
            p[i] = true;
        }
        for(int i = 2; i <= 1000000; i++) {
            for(int j = i * 2; j <= 1000000; j += i) {
                if(!p[j]) continue;
                p[j] = false;
            }
        }
    }
}
