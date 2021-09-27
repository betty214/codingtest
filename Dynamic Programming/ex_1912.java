package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] array=new int[N];
        int [] DP=new int[N];

        int min_index=0;
        int max_index=0;
        StringTokenizer st=new StringTokenizer(br.readLine());
        int index_1=Integer.parseInt(st.nextToken());
        int min=index_1;
        int max=index_1;
        DP[0]=index_1;
        int sum=index_1;
        for(int i=1;i<N;i++){
            array[i] = Integer.parseInt(st.nextToken());
            sum+=array[i];
            DP[i]=sum;
            if(DP[i]>max){
                max=DP[i];
                max_index=i;
            }if(DP[i]<=min){
                min=DP[i];
                min_index=i;
            }
        }
        if(max_index<min_index && max>=0 && min<0){
            max=0;
            for(int i=min_index;i<N;i++){
                if(DP[i]>max){
                    max=DP[i];
                    max_index=i;
                }
            }
        }
        if(max_index>min_index && min<0 && max>=0){
            System.out.println(max-min);
        }else{
            System.out.println(Math.max(max,array[N-1]));
        }
    }
}
