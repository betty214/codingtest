package baeckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex_1644 {
    static int N;
    static boolean[] isPrime;
    static ArrayList<Integer> prime_number;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        isPrime=new boolean[N+1];
        Arrays.fill(isPrime,true);
        isPrime[1]=false;
        prime();
        prime_number=new ArrayList<>();
        for(int i=1;i<=N;i++){
            if(isPrime[i]){
                prime_number.add(i);
            }
        }

        int count=0;
        for(int i=0;i<prime_number.size();i++){
            int sum=0;
            for(int s=i;s<prime_number.size();s++){
                sum+=prime_number.get(s);
                if(sum>=N){
                    break;
                }
            }if(sum==N){
                count++;
            }
        }
        System.out.println(count);
    }static void prime(){
        for(int i=2;i<=Math.sqrt(N);i++){
            if(isPrime[i]){
                for(int j=i*i;j<=N;j+=i){
                    isPrime[j]=false;
                }
            }
        }
    }
}
