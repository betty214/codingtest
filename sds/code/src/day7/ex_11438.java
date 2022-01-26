package day7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_11438 {
    static int [] depth;
    static int[][] parent;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/day7/11438.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        depth=new int[N+1];
        parent=new int[N][N+1];
        StringTokenizer st;
        depth[1]=0;
        for(int i=0;i<N-1;i++){
            st=new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(x==1){
                depth[y]=1;
                parent[0][y]=x;
            }
            else{
                if(depth[x]!=0) {
                    depth[y]=depth[x]+1;
                    parent[0][y]=x;
                }
                else {
                    depth[x]=depth[y]+1;
                    parent[0][x]=y;
                }
            }
        }
        int index=0;
        for(int i=1;i<N;i++){
            boolean flag=false;
            for(int j=1;j<=N;j++){
                parent[i][j]=parent[0][parent[i-1][j]];
                if(parent[i][j]!=0) flag=true;
            }
            if(!flag) {
                index=i;
                break;
            }
        }
        int M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int diff=Math.abs(depth[x]-depth[y]);
            System.out.println(LCA(x,y,diff));
        }
    }static int LCA(int x, int y,int diff){
        if(diff==0){
            if(x==y) return x;
            else{
                int i=0;
                while(parent[i][x]!=parent[i][y]){
                    i++;
                }return parent[i][x];
            }
        }return 0;
    }
}
