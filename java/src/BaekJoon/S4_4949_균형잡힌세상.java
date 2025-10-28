package 백주니;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 균형잡힌세상 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			char[] arr = br.readLine().toCharArray();
			
			if (arr.length == 1 && arr[0] == '.') {
				break;
			}
			
			Stack<Character> stack = new Stack<>();
			
			for(int i=0; i<arr.length; i++) {
				if (arr[i] == '(' || arr[i] == '[') {
					stack.push(arr[i]);
				}
				else if (arr[i] == ')') {
					if (!stack.isEmpty()) {
						if (stack.pop() != '(') {
							sb.append("no\n");
							break;
						}
					} else {
						sb.append("no\n");
						break;
					}
				}
				else if (arr[i] == ']') {
					if (!stack.isEmpty()) {
						if (stack.pop() != '[') {
							sb.append("no\n");
							break;
						}
					} else {
						sb.append("no\n");
						break;
					}
				}
				else if (i == arr.length -1 && stack.isEmpty()) {
					sb.append("yes\n");
				}
				else if (i == arr.length -1 && !stack.isEmpty()) {
					sb.append("no\n");
				}
			}
			
		} // while
		
		System.out.println(sb);
	} // main
}