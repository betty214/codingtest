package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class ex_1946 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			int [][]score=new int [N][3];
			for(int j=0;j<N;j++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				score[j][0] = Integer.parseInt(st.nextToken());
				score[j][1] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(score, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0]-o2[0];
				}
			});
			int count=1;
			int min=score[0][1];
			for(int x=1;x<N;x++) {
				if(score[x][1]<min) {
					min=score[x][1];
					count++;
				}
			}System.out.println(count);count=0;
		}
	}
}
