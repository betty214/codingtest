package backjun;

import java.util.Scanner;

public class ex_1463 {
	public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dynamic = new int[N + 1];
        int[] defaultab = {-1, 0, 1, 1};

        if (N < 4) {
            System.out.println(defaultab[N]);
            return;
        }else {
            for (int i = 0; i < 4; i++) {
                dynamic[i] = defaultab[i];
            }
        }

        for (int i = 4; i <= N; i++) {
        	dynamic[i] = 1+dynamic[i-1];
        	if(i%3==0) {
               dynamic[i] = Math.min(dynamic[i], dynamic[i/3]+1);
        	}if(i%2==0) {
                dynamic[i] = Math.min(dynamic[i], dynamic[i/2]+1);
        	}
        }
        System.out.println(dynamic[N]);
    }
}
