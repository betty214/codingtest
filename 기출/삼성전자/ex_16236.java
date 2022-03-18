package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ex_16236 {
    static int N,size,answer,temp;
    static int []dx={1,-1,0,0};
    static int[]dy={0,0,1,-1};
    static int[][]fish;
    static Queue<Shark>q;
    static class Shark{
        int x;
        int y;
        int dist;
        public Shark(int x, int y,int dist){
            this.x=x;
            this.y=y;
            this.dist=dist;
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input/16236.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        fish=new int[N][N];
        q=new LinkedList<>();
        size=2;
        answer=0;
        temp=0;

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                fish[i][j]=Integer.parseInt(st.nextToken());
                if(fish[i][j]==9) {
                    q.add(new Shark(i,j,size));
                    fish[i][j]=0;
                }
            }
        }
        while(!q.isEmpty()){
            ArrayList<Shark> f= new ArrayList<>();
            int[][]dist=new int[N][N];

            while(!q.isEmpty()){
                Shark now = q.poll();
                for(int i=0;i<4;i++){
                    int cx=now.x+dx[i];
                    int cy=now.y+dy[i];
                    if(check(cx,cy)){
                        if(dist[cx][cy]==0 && fish[cx][cy]<=size){
                            dist[cx][cy]=dist[now.x][now.y]+1;
                            if(fish[cx][cy]>0 && fish[cx][cy]<size && fish[cx][cy]<7) {
                                f.add(new Shark(cx,cy,dist[cx][cy]));
                                q.add(new Shark(cx,cy,dist[cx][cy]));
                                continue;
                            }
                            q.add(new Shark(cx,cy,dist[cx][cy]));
                        }
                    }
                }
            }
            if(f.size() == 0){
                System.out.println(answer);
                return;
            }
            Shark eatingFish = f.get(0);
            for(int i=1; i<f.size(); i++){
                if(eatingFish.dist > f.get(i).dist) {
                    eatingFish = f.get(i);
                }

                if(eatingFish.dist == f.get(i).dist) {
                    if(eatingFish.x > f.get(i).x){
                        eatingFish = f.get(i);
                        continue;
                    }else if(eatingFish.x == f.get(i).x){
                        if(eatingFish.y > f.get(i).y);
                        eatingFish = f.get(i);
                    }
                }
            }

            answer += eatingFish.dist;
            temp++;
            fish[eatingFish.x][eatingFish.y] = 0;
            if(temp == size) {
                size++;
                temp = 0;
            }
            q.add(new Shark(eatingFish.x, eatingFish.y, size));
        }

    }static boolean check(int x,int y){
        if(x<0||y<0||x>=N||y>=N) return false;
        return true;
    }
}
