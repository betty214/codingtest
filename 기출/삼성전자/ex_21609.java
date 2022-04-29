package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class ex_21609 {
    static int N,M,groupIdx,answer;
    static boolean flag;
    static int[][] block,group;
    static ArrayList<Node>groupCount;
    static int []dx={1,-1,0,0};
    static int[]dy={0,0,1,-1};
    static class Node{
        int x;
        int y;
        int num;
        Node(int x, int y){
            this.x=x;
            this.y=y;
        }
        Node(int x, int y,int num){
            this.x=x;
            this.y=y;
            this.num=num;
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input/21609.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        block=new int[N][N];
        group=new int[N][N];

        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                block[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        flag=true;
        while(flag){
            findBlock();
            turn90();
            print();
            System.out.println(answer);
        }
    }
    //90도 뒤집는 함수
    static void turn90(){
        int[][]temp=new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=1;j<=N;j++){
                temp[N-j][i]=block[i][j-1];
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                block[i][j]=temp[i][j];
            }
        }
        gravity();
    }
    //중력 적용 함수
    static void gravity(){
        for(int i=N-1;i>=0;i--){
            for(int j=0;j<N;j++){
                if(block[i][j]>=0){
                    int end=0;
                    for(int k=i+1;k<N;k++){
                        if(block[k][j]!=-2) {
                            end=k;
                            break;
                        }
                        if(k==N-1) end=N;
                    }
                    if(end!=0 && end!=i+1){
                        block[end-1][j]=block[i][j];
                        block[i][j]=-2;
                    }
                }
            }
        }
    }
    //블록을 비우고 점수 획득하는 함수
    static void clearBlock(Node groupNow, int numNow){
        Queue<Node> q=new LinkedList<>();
        q.add(groupNow);
        group[groupNow.x][groupNow.y]=groupCount.size()+1;
        boolean [][]visited=new boolean[N][N];
        visited[groupNow.x][groupNow.y]=true;
        while(!q.isEmpty()){
            Node now = q.poll();
            for(int i=0;i<4;i++){
                int cx=now.x+dx[i];
                int cy=now.y+dy[i];
                if(check(cx,cy)){
                    if(visited[cx][cy] || block[cx][cy]==-1) continue;
                    if(block[cx][cy]==groupNow.num){
                        q.add(new Node(cx,cy));
                        block[cx][cy]=-2;
                        visited[cx][cy]=true;
                    } else if(block[cx][cy]==0){
                        q.add(new Node(cx,cy));
                        block[cx][cy]=-2;
                        visited[cx][cy]=true;
                    }
                }
            }
        }
        answer+=numNow*numNow;
        gravity();
    }
    //블록 그룹을 모두 찾아 크기가 가장 큰 그룹을 찾는 함수
    static void findBlock(){
        group=new int[N][N];
        groupCount= new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(group[i][j]==0 && block[i][j]>0){
                    BFS(i,j);
                }
            }
        }
        Node maxGroup=new Node(0,0,0);
        int maxCount=0;
        flag=false;
        for(int i=groupCount.size()-1;i>=0;i--){
            int now=groupCount.get(i).num;
            if(maxCount<now) {
                maxGroup=groupCount.get(i);
                maxCount=now;
            }
            if(now>1) flag=true;
        }
        if(flag) clearBlock(maxGroup,maxCount);
    }static void BFS(int x, int y){
        Queue<Node> q=new LinkedList<>();
        q.add(new Node(x,y));
        group[x][y]=groupCount.size()+1;
        int preNum=block[x][y];
        boolean [][]visited=new boolean[N][N];
        int count=1;
        visited[x][y]=true;
        while(!q.isEmpty()){
            Node now = q.poll();
            for(int i=0;i<4;i++){
                int cx=now.x+dx[i];
                int cy=now.y+dy[i];
                if(check(cx,cy)){
                    if(group[cx][cy]!=0 || visited[cx][cy] || block[cx][cy]==-1) continue;
                    if(block[cx][cy]==preNum){
                        group[cx][cy]=group[now.x][now.y];
                        visited[cx][cy]=true;
                        q.add(new Node(cx,cy));
                        count++;
                    } else if(block[cx][cy]==0){
                        q.add(new Node(cx,cy));
                        visited[cx][cy]=true;
                        count++;
                    }
                }
            }
        }
        groupCount.add(new Node(x,y,count));
    }static boolean check(int x, int y){
        if(x<0 || y<0||x>=N ||y>=N) return false;
        return true;
    }static void print(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(block[i][j]==-2) System.out.print("[] ");
                else System.out.print(block[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
