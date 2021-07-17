package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ex_9205 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++) {
			int n=Integer.parseInt(br.readLine());
			int[][] dist = new int[n + 2][n + 2];
            boolean[][] check = new boolean[n + 2][n + 2];
            List<int[]> point = new ArrayList<>();
            for (int m = 0; m < n + 2; m++) {
            	StringTokenizer st = new StringTokenizer(br.readLine());
            	point.add(new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
            }
            for (int k = 0; k < n + 2; k++) {
            	for (int j = 0; j < n + 2; j++) {
                    int[] p1 = point.get(k);
                    int[] p2 = point.get(j);
                    dist[k][j] = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
                    if (dist[k][j] <= 1000) {
                    	check[k][j] = true;
                    }
                }
            }
            for (int k = 0; k < n + 2; k++) {
            	for (int l = 0; l < n + 2; l++) {
            		for (int j = 0; j < n + 2; j++) {
            			if (check[l][k] & check[k][j]) {
            				check[l][j] = true;
            			}
            		}
            	}
            }
            if(check[0][n + 1]) {
            	System.out.println("happy");
            }else {
            	System.out.println("sad");
            }
		}
	}
}
