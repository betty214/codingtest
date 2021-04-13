package eper;
import java.util.*;

class Word implements Comparable<Word>{
    String word;
    int count; //말해진 횟수
    
    public Word(String word) {
        this.word = word;
        this.count = 0;
    }
 
    public int compareTo(Word o) {
        // 말한 횟수가 작은 순으로 정렬하되, 말한 횟수가 같다면 알파벳 순으로 정렬
        if (this.count == o.count)
            return this.word.compareTo(o.word);
        else return this.count - o.count;
    }
}
 
public class ex_5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int k, n;
        String word, user_input;
        Word temp_word;
 
        // 'a'부터 'z'까지 그 글자로 시작하는 단어를 담을 priorityQueue를 각각 생성.
        List<PriorityQueue<Word>> pqs = new LinkedList<>();
        for(int i=0; i<('z'-'a'+1); i++)
            pqs.add(new PriorityQueue<>());
        
        // k, n 입력받기
        k = scanner.nextInt();
        n = scanner.nextInt();
        scanner.nextLine();
 
        // 미리 주어지는 단어 입력 받기
        for(int i=0; i<k; i++){
            // 입력받은 글자로 Word 인스턴스 생성 후, 맞는 PriorityQueue에 담기.
            word = scanner.nextLine();
            pqs.get(word.charAt(0)-'a').add(new Word(word));
            System.out.println();
        }
        // 단어 게임 시작
        for(int i=0; i<n; i++){
            user_input = scanner.nextLine();
            
            // 해당 글자로 시작하는 단어 중 가장 우선인것 꺼내어 출력하기.
            temp_word = pqs.get(user_input.charAt(0)-'a').poll();
            System.out.println(temp_word.word);
            
            // 한번 말해졌으므로, count 증가시키고 다시 queue에 넣기.
            temp_word.count++;
            pqs.get(user_input.charAt(0)-'a').add(temp_word);
        } 
	}
}
