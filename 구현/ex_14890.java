package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_14890 {
    static int N, L, answer;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer=0;
        for (int i = 0; i < N; i++) {
            int pre = map[i][0];
            boolean []visited = new boolean[N];
            boolean flag = true;
            for (int j = 1; j < N; j++) {
                if (Math.abs(map[i][j] - pre) >= 1) {
                    if(Math.abs(map[i][j] - pre)>1){
                        flag=false;
                    }else{
                        if(map[i][j] - pre==1){
                            int count=L;
                            if(!visited[j-1]){
                                visited[j-1]=true;
                            }else{
                                flag=false;
                            }
                            for(int k=1;k<L;k++){
                                if(check(i,j-k-1)){
                                    if(map[i][j-1-k]!=map[i][j-1]){
                                        flag=false;
                                    }else{
                                        if(!visited[j-1-k]){
                                            count--;
                                            visited[j-1-k]=true;
                                        }
                                    }
                                }
                            }if(count!=1){
                                flag=false;
                            }
                        }else{
                            int count=L;
                            if(!visited[j]){
                                visited[j]=true;
                            }else{
                                flag=false;
                            }
                            for(int k=1;k<L;k++){
                                if(check(i,j+k)){
                                    if(map[i][j+k]!=map[i][j]){
                                        flag=false;
                                    }else{
                                        if(!visited[j+k]){
                                            count--;
                                            visited[j+k]=true;
                                        }
                                    }
                                }
                            }if(count!=1){
                                flag=false;
                            }
                        }
                    }
                }pre=map[i][j];
            }if(flag){
                answer++;
            }
        }
        for (int i = 0; i < N; i++) {
            int pre = map[0][i];
            boolean flag = true;
            boolean []visited = new boolean[N];
            for (int j = 1; j < N; j++) {
                if (Math.abs(map[j][i] - pre) >= 1) {
                    if(Math.abs(map[j][i] - pre)>1){
                        flag=false;
                    }else{
                        if(map[j][i] - pre==1){
                            int count=L;
                            if(!visited[j-1]){
                                visited[j-1]=true;
                            }else{
                                flag=false;
                            }
                            for(int k=1;k<L;k++){
                                if(check(j-k-1,i)){
                                    if(map[j-1-k][i]!=map[j-1][i]){
                                        flag=false;
                                    }if(!visited[j-1-k]){
                                        count--;
                                    }visited[j-1-k]=true;
                                }
                            }if(count!=1){
                                flag=false;
                            }
                        }else{
                            int count=L;
                            if(!visited[j]){
                                visited[j]=true;
                            }else{
                                flag=false;
                            }
                            for(int k=1;k<L;k++){
                                if(check(j+k,i)){
                                    if(map[j+k][i]!=map[j][i]){
                                        flag=false;
                                    }if(!visited[j+k]){
                                        count--;
                                    }visited[j+k]=true;
                                }
                            }if(count!=1){
                                flag=false;
                            }
                        }
                    }
                }pre=map[j][i];
            }
            if(flag){
                answer++;
            }
        }
        System.out.println(answer);
    }static boolean check(int x,int y){
        if(x<0||y<0||x>=N||y>=N){
            return false;
        }else{
            return true;
        }
    }

}
