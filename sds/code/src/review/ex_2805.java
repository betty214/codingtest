package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex_2805 {
    static int[]tree;
    static int N;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/input/2805.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N =Integer.parseInt(st.nextToken());
        int M =Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        tree=new int[N];

        for(int i=0;i<N;i++){
            tree[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tree);
        long min=0;
        long max=tree[N-1];
        long now = (min+max)/2;
        long answer=0;
        long pre=answer;
        while(min<max){
            long cutting=cut(now);
            if(cutting==pre) break;
            if(cutting>=M) {
                if(Long.MAX_VALUE>cutting) answer=now;
                min=now;
                now = (min+max)/2;
                pre=cutting;
            } else{
                max=now;
                now = (min+max)/2;
            }
        }
        System.out.println(answer);
    }static long cut(long H){
        long sum=0;
        for(int i=0;i<N;i++){
            long temp=tree[i]-H;
            if(temp>0) sum+=temp;
        }
        return sum;
    }
}
