package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class quadtree {
	    static int tCase, pointer;
	    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 
	    public static void main(String[] args) throws NumberFormatException, IOException {
	 
	        tCase = Integer.parseInt(br.readLine());
	 
	        for (int t = 1; t <= tCase; t++) {
	 
	            pointer = -1;
	            String input = br.readLine();
	            System.out.println(recursive(input));
	        }
	    }
	 
	    public static String recursive(String input) {
	 
	        pointer += 1;
	        char ch = input.charAt(pointer);
	        if (ch == 'b' || ch == 'w') {
	            return ch + "";
	        }
	 
	        String leftUp = recursive(input);
	        String rightUp = recursive(input);
	        String leftDown = recursive(input);
	        String rightDown = recursive(input);
	 
	        return "x" + leftDown + rightDown + leftUp + rightUp;
	 
	    }
}

