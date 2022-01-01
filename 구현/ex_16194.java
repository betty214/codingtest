package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ex_16194 {
    private static class Node implements Comparable<Node>{
        int price;
        int index;
        public Node(int price,int index){
            this.price=price;
            this.index=index;
        }
        @Override
        public int compareTo(Node o) {
            return price - o.price;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Node> list =new ArrayList<>();
        int answer = Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            int input=Integer.parseInt(st.nextToken());
            list.add(new Node(input,i+1));
        }
        Collections.sort(list);
        for(int i=0;i<N;i++){
            if(N%(i+1)==0){
                int now_price=list.get(i).price*(N/(i+1));
                if(answer>now_price) answer=now_price;
            }
        }
        System.out.println(answer);
    }
}
