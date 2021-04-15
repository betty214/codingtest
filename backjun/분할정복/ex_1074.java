package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_1074 {
	public static int N, r, c, n, index, count, x, y;
	public static int[][] arr;

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = stoi(st.nextToken());
		r = stoi(st.nextToken());
		c = stoi(st.nextToken());

		n = getSize(N);
		count = 0;
		x = 0;
		y = 0;
		check();
	}

	public static void check() {
		if (n == 1) {
			System.out.println(count);
		}
		else {
			n /= 2;
			if (r < x + n && c < y + n) {
				count += n * n * 0;
			}
			else if (r < x + n) {
				count += n * n * 1;
				y += n;
			}
			else if (c < y + n) {
				count += n * n * 2;
				x += n;
			}
			else {
				count += n * n * 3;
				x += n;
				y += n;
			}check();
		}
	}public static int getSize(int n) {
        int result = 1;
        for(int i=0; i<n; i++) {
            result *= 2;
        }
        return result;
    }
}
