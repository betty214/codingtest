package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_6603 {
    static int[]number;
    static boolean[]visited;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        while(N!=0){
            number=new int[N];
            visited=new boolean[N];
            for(int i=0;i<N;i++){
                number[i]=Integer.parseInt(st.nextToken());
            }
            DFS(0,0);
            System.out.println();
            st=new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken());
        }
    }static void DFS(int start, int depth){
        if(depth==6){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<N;i++){
                if(visited[i]){
                    sb.append(number[i]+" ");
                }
            }
            System.out.println(sb.toString());
        }
        for (int i = start; i <N ; i++) {
            visited[i] = true;
            DFS(i+1, depth+1);
            visited[i] = false;
        }
    }
}
