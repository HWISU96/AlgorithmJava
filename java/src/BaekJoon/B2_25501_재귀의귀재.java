package 김휘수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 재귀의귀재25501b2 {
	static String s;
	static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; t++) {
			count = 0;
			String S = br.readLine();
			System.out.println(isPalindrome(S)+ " " + count);                                                                                                                                                                                                                                                                   			
		}
		
	}
	
	static int isPalindrome(String s){
	    return recursion(s, 0, s.length()-1);
	}
	
	static int recursion(String s, int l, int r){
		count++;
	    if(l >= r) return 1;
	    else if(s.charAt(l) != s.charAt(r)) return 0;
	    else return recursion(s, l+1, r-1);
	}
	
}