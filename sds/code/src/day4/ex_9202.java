package day4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ex_9202 {
    private static class Trie {
        String now;
        Trie[] children = new Trie[26];
        boolean isEnd = false;

        public Trie(String now) {
            this.now = now;
        }

        @Override
        public String toString() {
            return "Trie{" +
                    "now='" + now + '\'' +
                    ", children=" + Arrays.toString(children) +
                    ", isEnd=" + isEnd +
                    '}';
        }
    }

    private static class Node {
        int x;
        int y;
        Trie tri;

        public Node(int x, int y, Trie tri) {
            this.x = x;
            this.y = y;
            this.tri = tri;
        }
    }

    static Trie root;
    static char[][] board;
    static boolean[][] visited;
    static final int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    static final int[] dy = {0, 0, 1, -1, 1, -1, -1, 1};
    static ArrayList<String>answer;
    static int score;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/day4/9202.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int w = Integer.parseInt(br.readLine());
        root = new Trie("");
        for (int i = 0; i < w; i++) {
            String input = br.readLine();
            trie_input(input);
        }
        br.readLine();
        int b = Integer.parseInt(br.readLine());
        for (int i = 0; i < b; i++) {
            board = new char[4][4];
            for (int j = 0; j < 4; j++) {
                String input = br.readLine();
                for (int k = 0; k < 4; k++) {
                    board[j][k] = input.charAt(k);
                }
            }
            answer=new ArrayList<>();
            score=0;
            turn();
            String word=ans();
            System.out.println(score+" "+word+" "+ answer.size());
            br.readLine();
        }

    }

    static void trie_input(String input) {
        Trie pre = root;
        int index = 0;
        while (index < input.length()) {
            Trie child = new Trie(pre.now + input.substring(index, index + 1));
            pre.children[input.charAt(index) - 'A'] = child;
            pre = child;
            index++;
            if (index == input.length()) child.isEnd = true;
        }
    }

    static void turn() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                visited = new boolean[4][4];
                if (root.children[board[i][j] - 'A'] != null) {
                    DFS(i, j, root.children[board[i][j] - 'A']);
                }
            }
        }
    }

    static void DFS(int x, int y, Trie t) {
        visited[x][y]=true;
        for (int i = 0; i < 8; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];
            if(check(cx,cy)){
                char place = board[cx][cy];
                if (t.children[place - 'A'] != null && !visited[cx][cy]) {
                    t=t.children[place - 'A'];
                    if(t.isEnd && !answer.contains(t.now)) answer.add(t.now);
                    else {
                        DFS(cx, cy, t);
                    }
                }
            }
        }
    }static boolean check(int x, int y){
        if(x<0||y<0||x>3||y>3) return false;
        return true;
    }static String ans(){
        int max=0;
        String long_word="";
        Collections.sort(answer);
        for(int i=0;i<answer.size();i++){
            String now=answer.get(i);
            int len=now.length();
            if(len>max) {
                long_word=now;
                max=len;
            }
            if(len==3 || len==4) score++;
            else if(len==5) score+=2;
            else if(len==6) score+=3;
            else if(len==7) score+=5;
            else if(len==8) score+=11;
        }
        return long_word;
    }
}
