package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class ex_12100 {
    private static class Node{
        int x;
        int y;
        int num;
        public Node (int x,int y, int num){
            this.x=x;
            this.y=y;
            this.num=num;
        }
    }
    static int N,answer;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input/12100.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][]board=new int[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer=0;
        for(int i=0;i<4;i++){
            DFS(board, 0, i);
        }
        System.out.println(answer);
    }static void DFS(int [][]now, int depth, int dir){
        if(depth==4){
            return;
        }
        Stack<Node>s=new Stack<>();
        boolean flag=true;
        switch(dir){
            case 0: //상
                for(int i=0;i<N;i++){
                    for(int j=0;j<N;j++){
                        if(now[j][i]==0) continue;
                        answer=Math.max(answer,now[j][i]);
                        if(s.size()==0){
                            s.add(new Node(j,i,now[j][i]));
                        }else{
                            int pre=s.peek().num;
                            if(pre==now[j][i] && s.peek().y==i && flag) {
                                s.peek().num*=2;
                                flag=false;
                            }
                            else s.add(new Node(j,i,now[j][i]));
                        }
                    }flag=true;
                }
                break;
            case 1: //하
                for(int i=0;i<N;i++){
                    for(int j=N-1;j>=0;j--){
                        if(now[j][i]==0) continue;
                        answer=Math.max(answer,now[j][i]);
                        if(s.size()==0){
                            s.add(new Node(j,i,now[j][i]));
                        }else{
                            int pre=s.peek().num;
                            if(pre==now[j][i] && s.peek().y==i && flag) {
                                s.peek().num*=2;
                                flag=false;
                            }
                            else s.add(new Node(j,i,now[j][i]));
                        }
                    }flag=true;
                }
                break;
            case 2: //좌
                for(int i=0;i<N;i++){
                    for(int j=0;j<N;j++){
                        if(now[i][j]==0) continue;
                        answer=Math.max(answer,now[i][j]);
                        if(s.size()==0){
                            s.add(new Node(i,j,now[i][j]));
                        }else{
                            int pre=s.peek().num;
                            if(pre==now[i][j] && s.peek().x==i && flag) {
                                s.peek().num*=2;
                                flag=false;
                            }
                            else s.add(new Node(i,j,now[i][j]));
                        }
                    }flag=true;
                }
                break;
            case 3: //우
                for(int i=0;i<N;i++){
                    for(int j=N-1;j>=0;j--){
                        if(now[i][j]==0) continue;
                        answer=Math.max(answer,now[i][j]);
                        if(s.size()==0){
                            s.add(new Node(i,j,now[i][j]));
                        }else {
                            int pre = s.peek().num;
                            if (pre == now[i][j] && s.peek().x == i && flag) {
                                s.peek().num *= 2;
                            } else s.add(new Node(i, j, now[i][j]));
                        }
                    }flag=true;
                }
                break;
        }
        int[][]temp=new int[N][N];
        for(int i=0;i<s.size();i++){
            Node n = s.pop();
            temp[n.x][n.y]=n.num;
        }
        for(int i=0;i<4;i++){
            DFS(temp, depth+1 ,i);
        }

    }
}
