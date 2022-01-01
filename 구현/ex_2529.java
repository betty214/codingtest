package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_2529 {
    static boolean[] down,visited;
    static int K;
    static long min,max;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        down = new boolean[K];
        visited = new boolean[10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<K;i++){
            String big = st.nextToken();
            if(big.equals("<")) down[i]=true;
            else down[i]=false;
        }
        int[] number= {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        min=Long.MAX_VALUE;
        max=Long.MIN_VALUE;
        perm(number,K+1,0);
        System.out.println(max);
        System.out.println(min);
    }static void perm(int[]num,int n,int d){
        if (d == n) {
            long now = 0;
            int dec=1;
            int pre = num[0];
            boolean flag=true;
            for(int i=1;i<d;i++){
                if(down[i-1]){
                    if(pre>=num[i]){
                        flag=false;
                        break;
                    }
                }else{
                    if(pre<=num[i]){
                        flag=false;
                        break;
                    }
                }pre=num[i];
            }
            if(flag){
                for (int i = d-1; i >= 0; i--){
                    now+=num[i]*dec;
                    dec*=10;
                }
                if(now<min){
                    min=now;
                }if(now>max){
                    max=now;
                }
            }
            return;
        }
        for (int i=d; i<10; i++) {
            swap(num, d, i);
            perm(num, n, d + 1);
            swap(num, d, i);
        }
    }static void swap(int[]num, int depth, int i) {
        int temp = num[depth];
        num[depth] = num[i];
        num[i] = temp;
    }
}
