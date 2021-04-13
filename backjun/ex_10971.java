package backjun;

import java.util.Scanner;

public class ex_10971 {
	public static int[] visited;
	public static int[][] W;
	public static int N;
	public static int min = 99999999;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		visited = new int[N];
		W = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				W[i][j] = scan.nextInt();
			}visited[i] = 0;
		}
		for (int i = 0; i < N; i++) {
			travel(i, i, 0, 0);
		}
		System.out.println(min);
	}

	public static void travel(int start, int cnt, int endf, int sum) {
		if (endf == N && start == cnt) {
			min = Math.min(min, sum);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (W[cnt][i] >0&& visited[i] == 0) {
				visited[i] = 1;
				sum += W[cnt][i];
				travel(start, i, endf + 1, sum);
				visited[i] = 0;
				sum -= W[cnt][i];
			}
		}

	}
}
