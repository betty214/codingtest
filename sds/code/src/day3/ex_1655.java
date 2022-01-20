package day3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ex_1655 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/day3/1655.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(br.readLine());
            if (min.size() == max.size()) max.offer(now);
            else min.offer(now);

            if (!min.isEmpty() && !max.isEmpty())
                if (min.peek() < max.peek()) {
                    int tmp = min.poll();
                    min.offer(max.poll());
                    max.offer(tmp);
                }
            System.out.println(max.peek());
        }
    }
}
