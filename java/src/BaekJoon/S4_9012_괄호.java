package 백주니;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t=0; t<T; t++) {
			Stack<Character> stack = new Stack<>();
			char[] arr = br.readLine().toCharArray();
			
			for (int i=0; i<arr.length; i++) {
				char token = arr[i];
				
				if (token == '(') {
					stack.add(token);
				}
				else {
					if (stack.isEmpty()) {
						sb.append("NO").append("\n");
						break;
					} else if (stack.peek() == '(') {
						stack.pop();
					} else {
						sb.append("NO").append("\n");
						break;
					}
				}
				
				if (stack.isEmpty() && i == arr.length-1) {
					sb.append("YES").append("\n");
				} else if (!stack.isEmpty() && i == arr.length-1) {
					sb.append("NO").append("\n");
				}
			} // for
			

		} // tc
		
		System.out.println(sb);
		
	}
}