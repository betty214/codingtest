package backjun;

import java.util.Scanner;

public class ex_12100 {
	public static int[][] arr;
	public static int n;
	public static int[] news = new int[4];
	public static int maxBlock;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		DFS(0);
		System.out.println(maxBlock);
	}

	public static void DFS(int cnt) {
		if (cnt == 5) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					maxBlock = Math.max(maxBlock, arr[i][j]);
				}
			}
			return;
		}
		int[][] copyBoard = new int[20][20];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				copyBoard[i][j] = arr[i][j];
			}
		}
		for (int i = 0; i < 4; i++) {
			shift(i);
			DFS(cnt + 1); 
			for (int k = 0; k < n; k++) {
				for (int j = 0; j < n; j++) {
					arr[k][j] = copyBoard[k][j];
				}      
			}
        }
	}
	public static void shift(int type) {
		switch(type) {
		case 0:
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n - 1; j++) {
					if (arr[i][j] == arr[i][j + 1]) {
						arr[i][j] *= 2;
						arr[i][j + 1] = 0;
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n - 1; j++) {
					if (arr[i][j] == 0) {
						arr[i][j] = arr[i][j + 1];
						arr[i][j + 1] = 0;
					}
				}
			}
			break;
		case 1:
			for (int i = 0; i < n; i++) {
				for (int j = n - 1; j > 0; j--) {
					if (arr[i][j] == arr[i][j - 1]) {
						arr[i][j] *= 2;
						arr[i][j - 1] = 0;
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = n - 1; j > 0; j--) {
					if (arr[i][j] == 0) {
						arr[i][j] = arr[i][j - 1];
						arr[i][j - 1] = 0;
					}
				}
			}
			break;
		case 2:

			for (int j = 0; j < n; j++) {
			for (int i = 0; i < n - 1; i++) {
					if (arr[i][j] == arr[i + 1][j]) {
						arr[i][j] *= 2;
						arr[i + 1][j] = 0;
					}
				}
			}
			for (int j = 0; j < n; j++) {
				for (int i = 0; i < n - 1; i++) {		
					if (arr[i][j] == 0) {
						arr[i][j] = arr[i + 1][j];
						arr[i + 1][j] = 0;
					}
				}
			}
			break;
		case 3:
			for (int j = 0; j < n; j++) {
				for (int i = n - 1; i > 0; i--) {
					if (arr[i][j] == arr[i - 1][j]) {
						arr[i][j] *= 2;
						arr[i - 1][j] = 0;
					}
				}
			}

			for (int j = 0; j < n; j++) {
			for (int i = n - 1; i > 0; i--) {
					if (arr[i][j] == 0) {
						arr[i][j] = arr[i - 1][j];
						arr[i - 1][j] = 0;
					}
				}
			}
			break;
		default:
			break;
		}
	}
}
