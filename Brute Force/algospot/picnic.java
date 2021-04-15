package algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class picnic{
	  public static StringBuilder sb = new StringBuilder();
	    public static Scanner sc = new Scanner(System.in);
	    public static int C;
	    public static int count=0;
	    public static int N;
	    public static int M;
	    //public static int[][] freindsMap;

	    public static List<Node> nodeList = new ArrayList<Node>();

	    public static void main(String[] args)  throws Exception{
	        C=sc.nextInt();
	        for(int i=0;i<C;i++) {
	            solve();
	        }
	        System.out.println(sb.toString());
	        sc.close();
	    }

	    public static void solve() throws Exception {
	        N = sc.nextInt();
	        M = sc.nextInt();

	        nodeList = new ArrayList<Node>();
	        count = 0;
	        boolean[] checkList = new boolean[N+1];
	        for (int i = 0; i < N; i++) {
	            checkList[i] = false;
	        }
	        for (int i = 0; i < M; i ++) {
	            nodeList.add(new Node(sc.nextInt(), sc.nextInt()));
	        }
	        for (Node node : nodeList) {
	            boolean[] tempck = checkList.clone();
	            tempck[node.a] = true;
	            tempck[node.b] = true;
	            picnic(tempck,  1);
	        }
	        int divid =combination();
	        sb.append(count / divid).append("\n");
	    }

	    public static void picnic(boolean[] checkList,  int num) throws Exception{
	        // 쌍을 모두 찾음
	        if(num == N/2){
	            count++;
	            return;
	        }
	        for(int i=0;num<N/2&&i<nodeList.size();i++){
	            Node node = nodeList.get(i);
	            if(!checkList[node.a] &&!checkList[node.b]){
	                boolean[] tempck = checkList.clone();

	                tempck[node.a] = true;
	                tempck[node.b] = true;

	                picnic(tempck,  num+1);
	            }
	        }
	    }

	    public static int combination(){
	        int result=1;
	        for(int i=1;i<=N/2;i++){
	            result *= i;
	        }
	        return result;
	    }
	    public static class Node {
	        int a;
	        int b;

	        public Node(int a, int b) {
	            this.a = a;
	            this.b = b;

	        }

	        @Override
	        public String toString() {
	            return "(" +
	                    a +
	                    ", " + b +
	                    ')';
	        }
	    }
	}