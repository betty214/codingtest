package eper;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ex_new4 {
	public static int[]dynamic,traps,tvisit,visited;
	public static int [][]roads;
	public static int start,end;
	public static void main(String[] args) {
		 Scanner scan = new Scanner(System.in);
	     int n = scan.nextInt();
	     start = scan.nextInt();
	     end = scan.nextInt();
	     roads=new int [2][3];
	     traps = new int[1];
	     tvisit = new int[1];
	     visited = new int[n];
	     dynamic=new int[n+1];
	     int result=0;
	        for(int i=0;i<2;i++) {
	        	for(int j=0;j<3;j++) {
	        		roads[i][j]=scan.nextInt();
	        	}
	        }for(int i=0;i<1;i++) {
	        	traps[i]=scan.nextInt();
	        }
	        Arrays.sort(roads, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0]-o2[0];
				}
			});
	        Arrays.fill(dynamic,-1);
	        go(1);
	        for(int i=0;i<=n;i++) {
	        	System.out.println(dynamic[i]);
	        }
	}public static int go(int index) {
		System.out.println(index);
		if(index==end) {
			System.out.println("ds");
			return 0;
		}
		for(int i=0;i<1;i++) {
			if(traps[i]==index) {
				for(int j=0;j<2;i++) {
					if(roads[j][1]==index) {
						int temp=roads[j][0];
						roads[j][0]=roads[j][1];
						roads[j][1]=temp;
					}
					
					if(visited[roads[j][1]]==0) {
						visited[index]=1;
						dynamic[index]=roads[j][2]+go(roads[j][1]);
						visited[index]=0;
					}else {
						return 0;
					}
					
				}
				
			}
		}
		if (dynamic[index]==-1){
			int max=0,temp=0;
			for(int i=0;i<2;i++) {
				if(roads[i][0]==index&&visited[roads[i][1]]==0) {
					visited[index]=1;
					temp=roads[i][2]+go(roads[i][1]);
					visited[index]=0;
					if (max<temp) {
						max=temp;
					}
				}dynamic[index]=max;
			}
    	}
		return dynamic[index];
	}
}
