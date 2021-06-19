package backjun;

import java.util.LinkedList;
import java.util.Scanner;

public class ex_16236 {
    static int sea[][];
    static int n,eat,time,size;
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};
    static LinkedList<Shark> q ;
    static class Shark{
        int x;
        int y;
        int dist;
        public Shark(int x, int y, int dist) {
            super();
            this.x = x;
            this.y = y;
            this.dist = dist;
    }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
         
        sea = new int[n][n];
 
        //1. 먹을 물고기 있는지 탐색
        //1-1. 제일 가까운 물고기 탐색은 자연스럽게 BFS로 해결, 만약 먹을 물고리 동률-> 가장위 -> 가장 왼쪽
        //2. 먹을 물고기 찾으면,먹고 나이증가 체크
        //3. 큐에 있는 모든 포인트 날리고 현재 찾은 포인트만 add
        q = new LinkedList<>();
        size=2;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sea[i][j] = sc.nextInt();
                if(sea[i][j] == 9){
                    q.add(new Shark(i, j, size));
                    sea[i][j] = 0;
                }
            }
        }
        eat = 0;
        time = 0;
        while(true){
            Shark sShk = q.peek();
            LinkedList<Shark> fish = new LinkedList<>();
            int [][] dist = new int[n][n];// 거리
 
            while (!q.isEmpty()) {
                Shark s = q.poll();
                for(int i=0; i<4; i++){
                    int cx = s.x + dx[i];
                    int cy = s.y + dy[i];
                 
                    if(cx>=0 && cx<n && cy>=0 && cy<n && dist[cx][cy]==0 && sea[cx][cy] <= size){
                        dist[cx][cy] = dist[s.x][s.y] + 1;
                        if(1<=sea[cx][cy] && sea[cx][cy]<=6 && sea[cx][cy] < size){
                            fish.add(new Shark(cx, cy, dist[cx][cy]));
                            q.add(new Shark(cx, cy, dist[cx][cy]));
                            continue;
                        } 
                        q.add(new Shark(cx, cy, dist[cx][cy]));
                    }
                }
            }
 
            if(fish.size() == 0){
                System.out.println(time);
                return;
            }
            int d = 5000;
            Shark eatingFish = fish.get(0);
            for(int i=1; i<fish.size(); i++){
                if(eatingFish.dist > fish.get(i).dist) {
                    eatingFish = fish.get(i);
                }
                 
                if(eatingFish.dist == fish.get(i).dist) {
                    if(eatingFish.x > fish.get(i).x){
                        eatingFish = fish.get(i);
                        continue;
                    }else if(eatingFish.x == fish.get(i).x){
                        if(eatingFish.y > fish.get(i).y);
                        eatingFish = fish.get(i);   
                    }
                }   
            }
             
            time += eatingFish.dist;
            eat++;
            sea[eatingFish.x][eatingFish.y] = 0;
            if(eat == size) {
                size++;
                eat = 0;
            }
            q.add(new Shark(eatingFish.x, eatingFish.y, size));
 
        }
    	
    }
}
