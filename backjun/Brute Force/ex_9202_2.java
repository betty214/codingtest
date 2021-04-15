package backjun;

import java.io.*;
import java.util.*;

public class ex_9202_2 {
	//노드 선언 함수
	private static class Node {
		char data;
		boolean isEnd; //마지막이면 true
		Node[] child;

		Node(char c) {
			data = c;
			child = new Node[27];//알파벳 갯수
		}

		Node setChild(char c) {//삽입 시 array list add와 같은 역할
			if (c == '\0') {
				isEnd = true;
				return null;
			}

			if (child[c - 'A'] == null) {
				child[c - 'A'] = new Node(c);
			}
			return child[c - 'A'];
		}
	}
	//dfs 자료구조 선언 함수
	private static class Trie {
		Node n;

		Trie() {//초기화
			n = new Node('\0');
		}

		void add(String s) {//트리에 글자 하나하나씩 이어붙이기
			Node n = this.n;
			for (int i = 0; i < s.length(); i++) {
				n = n.setChild(s.charAt(i));
			}
			n.setChild('\0');
		}

		boolean isContain(int length) {//끝까지 일치하면 true 반환
			Node n = this.n;
			for (int i = 0; i < length; i++) {
				if (n.child[string[i] - 'A'] == null) {
					return false;
				}
				n = n.child[string[i] - 'A'];
			}
			return n.isEnd;
		}
	}

	static int N, size;
	static Trie trie = new Trie();
	static char[][] cube = new char[4][4];
	static boolean[][] visit = new boolean[4][4];
	static char[] string;
	static int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dy = { 0, 0, -1, 1, -1, 1, -1, 1 };
	static HashSet<String> hs = new HashSet<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());

		for (int i = 0; i < N; i++) {//단어 trie구조에 넣기
			trie.add(br.readLine());
		}

		br.readLine();
		N = stoi(br.readLine());

		for (int i = 0; i < N; i++) {//4x4의 그리드 개수 만큼. 예시에서는 3
			for (int j = 0; j < 4; j++) {
				char[] temp = br.readLine().toCharArray();
				for (int k = 0; k < 4; k++) {
					cube[j][k] = temp[k];//cube에 그리드 넣기
				}
			}
			init();
			search();//dfs탐색을 위한 호출

			if (i != N - 1) {//다음 거 불러오기
				br.readLine();
			}

			result();
		}
		System.out.println(sb.toString());
	}

	private static void search() {
		for (int i = 1; i <= 8; i++) {
			isPossible(i);//1~8의 길이만큼 호출. 단어의 길이와 일치해야 hashmap에 들어갈 수 있는듯
		}
	}

	private static void isPossible(int length) {
		size = length;
		string = new char[size];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				string[0] = cube[i][j];
				visit[i][j] = true;//중복 검색 방지
				dfs(i, j, 1);//dfs 호출
				visit[i][j] = false;
			}
		}
	}

	private static void dfs(int x, int y, int depth) {
		if (depth == size) {//단어 길이랑 일치하고 내용도 일치하며 hs에 삽입
			if (trie.isContain(depth) && !hs.contains(String.copyValueOf(string))) {
				hs.add(String.copyValueOf(string));
			}
			return;
		}

		for (int i = 0; i < 8; i++) {//현 depth에서 글자가 일치하면 다음 depth로 넘어가서 탐색
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < 4 && ny < 4 && !visit[nx][ny]) {
				string[depth] = cube[nx][ny];
				visit[nx][ny] = true;
				dfs(nx, ny, depth + 1);
				visit[nx][ny] = false;
			}
		}
	}

	private static void init() {
		hs.clear();
	}

	private static void result() {//결과값 출력 함수
		ArrayList<String> list = new ArrayList<>(hs);
		Collections.sort(list);

		int point = 0, count = 0;
		String result = "";

		for (String s : list) {
			if (s.length() > result.length()) {
				result = s;
			}
			point += calc(s);
			count++;
		}
		sb.append(point + " " + result + " " + count + "\n");
	}

	private static int calc(String s) {//점수 계산 함수
		if (s.length() <= 2) {
			return 0;
		} else if (s.length() == 3) {
			return 1;
		} else if (s.length() <= 6) {
			return s.length() - 3;
		} else if (s.length() == 7) {
			return 5;
		} else if (s.length() == 8) {
			return 11;
		}
		return -1;
	}

	private static int stoi(String input) {
		return Integer.parseInt(input);
	}
}
