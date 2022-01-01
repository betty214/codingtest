package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ex_21608 {
    static int N;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static int[][]blank,seat;
    static int[]order;
    static ArrayList<Integer>[] like;
    private static class Node implements Comparable<Node>{
        int x;
        int y;
        int friend;
        int blank;
        int num;
        public Node(int x,int y,int num){
            this.x=x;
            this.y=y;
            this.num=num;
        }
        @Override
        public int compareTo(Node o) {
            if(this.friend != o.friend) return o.friend - this.friend;
            if(this.blank != o.blank) return o.blank - this.blank;
            if(this.x != o.x) return this.x - o.x;
            return this.y - o.y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        like = new ArrayList[N*N+1];
        seat =new int[N+1][N+1];
        blank =new int[N+1][N+1];
        order=new int[N*N];
        fill_blank();
        for (int i = 1; i <= N*N; i++) {
            like[i]=new ArrayList<>();
        }
        for(int i=0;i<N*N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            like[index].add(Integer.parseInt(st.nextToken()));
            like[index].add(Integer.parseInt(st.nextToken()));
            like[index].add(Integer.parseInt(st.nextToken()));
            like[index].add(Integer.parseInt(st.nextToken()));
            order[i]=index;
        }
        for(int i=0;i<N*N;i++){
            ArrayList<Node> list=find_friend(order[i]);
            Collections.sort(list);
            Node input = list.get(0);
            seat[input.x][input.y] = order[i];
            blank[input.x][input.y] = -1;

            for(int j=0; j<4; j++) {
                int cx = input.x + dx[j];
                int cy = input.y + dy[j];
                if(check(cx,cy)){
                    if(blank[cx][cy]>0){
                        blank[cx][cy]--;
                    }
                }
            }
        }
        System.out.println(satisfy());
    }
    static int satisfy(){
        int answer=0;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                ArrayList<Integer>nearby=new ArrayList<>();
                for(int k=0;k<4;k++){
                    int cx = i + dx[k];
                    int cy = j + dy[k];
                    if(check(cx,cy)){
                        nearby.add(seat[cx][cy]);
                    }
                }int count=0;
                for(int k=0;k<nearby.size();k++){
                    for(int t=0;t<4;t++){
                        if(nearby.get(k)==like[seat[i][j]].get(t)){
                            count++;
                            break;
                        }
                    }
                }if(count==1){
                    answer+=1;
                }else if(count==2){
                    answer+=10;
                }else if(count==3){
                    answer+=100;
                }else if(count==4){
                    answer+=1000;
                }
            }
        }return answer;
    }
    static ArrayList<Node> find_friend(int num) {
        ArrayList<Node> input_list = new ArrayList<>();
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(seat[i][j] != 0)
                    continue;
                Node now = new Node(i,j,num);
                now.blank = blank[i][j];
                int cnt = 0;
                for(int k=0; k<4; k++) {
                    int cx = i + dx[k];
                    int cy = j + dy[k];
                    if(check(cx,cy)){
                        for(int m=0; m<4; m++) {
                            for(int friend : like[num]) {
                                if(seat[cx][cy] == friend) {
                                    cnt++;
                                    break;
                                }
                            }
                        }
                    }
                }
                now.friend = cnt;
                input_list.add(now);
            }
        }
        return input_list;
    }
    static void fill_blank(){
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                int count=0;
                for(int k=0;k<4;k++){
                    int cx=i+dx[k];
                    int cy=j+dy[k];
                    if(check(cx,cy)){
                        if(seat[cx][cy]==0){
                            count++;
                        }
                    }
                }blank[i][j]=count;
            }
        }
    }
    static boolean check(int x,int y){
        if(x<=0||y<=0||x>N||y>N){
            return false;
        }else{
            return true;
        }
    }
}
