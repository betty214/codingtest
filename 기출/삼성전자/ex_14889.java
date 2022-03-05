package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_14889 {
    static int N,ans;
    static int[][]score;
    static boolean []visited;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input/14889.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        score=new int[N][N];
        ans=Integer.MAX_VALUE;
        visited=new boolean[N];

        for(int i=0;i<N;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                score[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        comb(0,0);
        System.out.println(ans);
    }static void comb(int idx,int depth){
        if(depth==N/2){
            ans=Math.min(ans, makeList());
            return;
        }
        for(int i=idx;i<N;i++){
            if(!visited[i]){
                visited[i]=true;
                comb(i+1,depth+1);
                visited[i]=false;
            }
        }
    }static int makeList(){
        int[]start=new int[N/2];
        int[]link=new int[N/2];
        int idxS=0; int idxL=0;

        for(int i=0;i<N;i++){
            if(visited[i]) start[idxS++]=i;
            else link[idxL++]=i;
        }
        int numS=count(start);
        int numL=count(link);
        return Math.abs(numL-numS);
    }static int count(int[]now){
        int sum=0;
        for(int i=0;i<N/2;i++){
            for(int j=i+1;j<N/2;j++){
                sum+=score[now[i]][now[j]];
                sum+=score[now[j]][now[i]];
            }
        }
        return sum;
    }
}