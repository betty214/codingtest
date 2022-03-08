package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex_14890 {
    static int N,L;
    static int[][]map,slide;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input/14890.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map=new int[N][N];
        slide=new int[N][N];
        int answer=0;

        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++){
            int pre=map[i][0];
            boolean flag=false;

            for(int j=1;j<N;j++){
                int now=map[i][j];

                if(Math.abs(now-pre)>1) flag=true;
                else if(pre!=now) flag=checkR(i,j);

                if(flag) break;
                pre=now;
            }

            if(!flag) {
                answer++;
            }
        }
        slide=new int[N][N];
        for(int i=0;i<N;i++){
            int pre=map[0][i];
            boolean flag=false;

            for(int j=1;j<N;j++){
                int now=map[j][i];

                if(Math.abs(now-pre)>1) flag=true;
                else if(pre!=now) flag=checkC(j,i);

                if(flag) break;
                pre=now;
            }

            if(!flag) {
                answer++;
            }
        }
        System.out.println(answer);
    }static boolean checkR(int x, int y){
        if(map[x][y-1]-map[x][y]==1){
            if(y>N-L) return true;
            else{
                for(int i=0;i<L;i++){
                    if(slide[x][y+i]>0) return true;
                    slide[x][y+i]++;
                }
            }
        }else{
            if(y<L) {
                return true;
            }
            else{
                for(int i=1;i<=L;i++){
                    if(slide[x][y-i]>0) return true;
                    slide[x][y-i]++;
                }
            }
        }
        return false;
    }static boolean checkC(int x, int y){
        if(map[x-1][y]-map[x][y]==1){
            if(x>N-L) return true;
            else{
                for(int i=0;i<L;i++){
                    if(slide[x+i][y]>0) return true;
                    slide[x+i][y]++;
                }
            }
        }else{
            if(x<L) {
                return true;
            }
            else{
                for(int i=1;i<=L;i++){
                    if(slide[x-i][y]>0) return true;
                    slide[x-i][y]++;
                }
            }
        }
        return false;
    }
}
