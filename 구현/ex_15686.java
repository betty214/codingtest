package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ex_15686 {
    static int N,M,answer;
    static int[][]city;
    static ArrayList<Node>home,chicken;
    static Stack<Node> temp_stack;
    private static class Node{
        int x;
        int y;
        public Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        city=new int[N][N];
        chicken = new ArrayList<>();
        home = new ArrayList<>();
        temp_stack=new Stack<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                city[i][j]=Integer.parseInt(st.nextToken());
                if(city[i][j]==1){
                    home.add(new Node(i,j));
                }else if(city[i][j]==2){
                    chicken.add(new Node(i,j));
                }
            }
        }
        answer=Integer.MAX_VALUE;
        DFS(0,0);
        System.out.println(answer);
    }
    static void DFS(int start, int count) {
        if (count == M) {
            distance();
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            temp_stack.push(chicken.get(i));
            DFS(i + 1, count + 1);
            temp_stack.pop();
        }
    }

    static void distance(){
        int sum = 0;
        for(int i=0;i< home.size();i++){
            Node house = home.get(i);
            int min = Integer.MAX_VALUE;
            for(int j=0;j<M;j++){
                Node now = temp_stack.get(j);
                int dist=Math.abs(house.x-now.x)+Math.abs(house.y-now.y);
                min = Math.min(min, dist);
            }
            sum += min;
            if (sum > answer) {
                return;
            }
        }
        answer= Math.min(sum, answer);
    }
}
