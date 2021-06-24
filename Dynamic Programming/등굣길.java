package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 등굣길 {
		public static void main(String[] args)throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int m = Integer.parseInt(br.readLine());
	        int n = Integer.parseInt(br.readLine());
	        int [][]puddles=new int [1][2];
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int tx = Integer.parseInt(st.nextToken());
	        int ty = Integer.parseInt(st.nextToken());
	        puddles[0][0]=tx;
	        puddles[0][1]=ty;
	        int [][] road = new int [m][n];
	        int [][] DP = new int[m][n];
	        for(int i=0;i<puddles.length;i++){
	            int x=puddles[i][0];
	            int y=puddles[i][1];
	            road[x-1][y-1]=1;
	        }DP[0][0]=1;
	        for(int i=0;i<m;i++){
	            for(int j=0;j<n;j++){
	                if(i==0&&j==0){
	                    DP[i][j]=1;
	                }else if(road[i][j]==1){
	                    DP[i][j]=-1;
	                }else{
	                    if(i==0){
	                        if(road[i][j-1]!=1){
	                           DP[i][j]=DP[i][j-1]%1000000007; 
	                        }else{
	                            DP[i][j]=-1;
	                        }
	                    }else if(j==0){
	                        if(road[i-1][j]!=1){
	                           DP[i][j]=DP[i-1][j]%1000000007; 
	                        }else{
	                            DP[i][j]=-1;
	                        }
	                    }else{
	                        if(DP[i-1][j]==-1&&DP[i][j-1]==-1){
	                        DP[i][j]=-1;
	                    }else if(DP[i-1][j]!=-1&&DP[i][j-1]==-1){
	                        DP[i][j]=DP[i-1][j]%1000000007;
	                    }else if(DP[i-1][j]==-1&&DP[i][j-1]!=-1){
	                        DP[i][j]=DP[i][j-1]%1000000007;
	                    }else{
	                        DP[i][j]=(DP[i-1][j]+DP[i][j-1])%1000000007;
	                    }
	                    }
	                    
	                }
	            }
	        }
	        int answer = DP[m-1][n-1]%1000000007;
	        if(answer==-1){
	            answer=0;
	        }
	        System.out.println(answer);
	    }
	}
