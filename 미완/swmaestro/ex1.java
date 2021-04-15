package swmaestro;
import java.util.Scanner;

public class ex1 {  
  public static void main(String args[]) { 
    
    Scanner input = new Scanner(System.in);
    int a=0;
    String b=input.next();
    char[] c = b.toCharArray();
    for(int i=0;i<c.length;i++){
        if(c[i]=='('){
            a++;
        }else{
            a--;
        }		
	}
    if(a==0){
        System.out.print("YES");
    }else{
        System.out.print("NO");
    }
  }
}
