package day4;
/*
숫자 배열의 순서를 역으로 바꾼 배열을 리턴하는 함수를 구현하시오.
속도가 빠르고, 사용 메모리가 적을수록 가산점이 부여됩니다.

* * */
public class test1 {
    public static void main(String[] args) {
        int []arr={1,2,3,4,5};

        reverse(arr);

    }static int[] reverse(int[]origin){
        int []answer=new int[origin.length];
        for(int i=0;i<=origin.length/2;i++){
            answer[origin.length-i-1]=origin[i];
            answer[i]=origin[origin.length-i-1];
        }return answer;
    }

}
