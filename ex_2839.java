package backjun;

import java.util.Scanner;

public class ex_2839 {
	public static void main(String args[]){
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();

            int[] dynamic = new int[N + 1];
            int[] defaultab = {-1, -1, -1, 1, -1, 1, 2, -1};

            if (N <= 7) {
                System.out.println(defaultab[N]);
                return;
            }
            else
                for (int i = 0; i <= 7; i++)
                    dynamic[i] = defaultab[i];

            for (int i = 8; i <= N; i++)

                if(dynamic[i-5] != -1 && dynamic[i-3] != -1)
                    dynamic[i] = 1 + Math.min(dynamic[i - 3], dynamic[i - 5]);

                else if(dynamic[i-5] == -1 && dynamic[i-3] != -1)
                    dynamic[i] = 1 + dynamic[i-3];

                else if(dynamic[i-5] != -1 && dynamic[i-3] == -1)
                    dynamic[i] = 1 + dynamic[i-5];

            System.out.println(dynamic[N]);
    }
}
