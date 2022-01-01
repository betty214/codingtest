package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ex_14226 {
    static class Node {
        int now;
        int clip;
        int time;

        public Node(int now, int clip, int time) {
            this.now = now;
            this.clip = clip;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] visited = new boolean[2001][2001];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 0, 0));

        while (!queue.isEmpty()) {
            Node emo = queue.poll();

            int now = emo.now;
            int clip = emo.clip;
            int time = emo.time;

            if (now == N) {
                System.out.println(time);
                return;
            }

            if (now > 0 && now < 2000) {
                if (!visited[now][now]) {
                    visited[now][now] = true;
                    queue.offer(new Node(now, now, time + 1));
                }
                if (!visited[now - 1][clip]) {
                    visited[now - 1][clip] = true;
                    queue.offer(new Node(now - 1, clip, time + 1));
                }
            }

            if (clip > 0 && now + clip < 2000) {
                if (!visited[now + clip][clip]) {
                    visited[now + clip][clip] = true;
                    queue.offer(new Node(now + clip, clip, time + 1));
                }
            }
        }
    }
}
