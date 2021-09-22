package baeckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex_1963 {
    static boolean[] isPrime;
    static ArrayList<Integer> prime_number;
    static ArrayList<Boolean> prime_visited;
    static int Y,answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int X=Integer.parseInt(st.nextToken());
            Y=Integer.parseInt(st.nextToken());
            if(X==Y){
                System.out.println(0);
            }else{
                isPrime=new boolean[Y+1];
                Arrays.fill(isPrime,true);
                isPrime[1]=false;
                prime(Y);
                prime_number=new ArrayList<>();
                prime_visited=new ArrayList<>();
                for(int j=X;j<=Y;j++){
                    if(isPrime[j]){
                        prime_number.add(j);
                        prime_visited.add(false);
                    }
                }answer=0;
                DFS(X);
            }
        }
    }static void prime(int N){
        for(int i=2;i<=Math.sqrt(N);i++){
            if(isPrime[i]){
                for(int j=i*i;j<=N;j+=i){
                    isPrime[j]=false;
                }
            }
        }
    }static ArrayList<Integer> move(int n){
        ArrayList<Integer> cand = new ArrayList<>();
        String n_str=Integer.toString(n);
        char[]n_char=n_str.toCharArray();
        for(int i=0;i<prime_number.size();i++){
            String x_str=Integer.toString(prime_number.get(i));
            char[]x_char=x_str.toCharArray();
            int count=0;
            for(int j=0;j<4;j++){
                if(x_char[j]==n_char[j]){
                    count++;
                }
            }if(count==3){
                cand.add(prime_number.get(i));
                prime_number.remove(prime_number.get(i));
            }
        }return cand;
    }static void DFS(int n){
        ArrayList<Integer> temp=move(n);
        for(int i=0;i< temp.size();i++){
            if(temp.get(i)==Y){
                System.out.println(answer);
                return;
            }else{
                answer++;
                DFS(temp.get(i));
            }
        }
    }
}
