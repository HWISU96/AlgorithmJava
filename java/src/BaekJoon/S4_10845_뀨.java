package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 큐 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque<>();
		StringTokenizer st;
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			if (st.countTokens() > 1) {
				st.nextToken();
				deque.offerFirst(Integer.parseInt(st.nextToken()));
			}
			else {
				String token = st.nextToken();
				
				if (token.equals("pop")) {
					if (deque.isEmpty() == true) {
						System.out.println(-1);
					}
					else {
						System.out.println(deque.pollFirst());
					}
				} // pop
				
				if (token.equals("size")) {
					System.out.println(deque.size());
				} // size
				
				if (token.equals("empty")) {
					if (deque.isEmpty()) System.out.println(1);
					else System.out.println(0);
				} // empty
				
				if (token.equals("front")) {
					if (deque.isEmpty()) System.out.println(-1);
					else System.out.println(deque.peekFirst());
				} // front
				
				if (token.equals("back")) {
					if (deque.isEmpty()) System.out.println(-1);
					else System.out.println(deque.peekLast());
				} // back
			} // push
			
			
			
		} // for
		
	}

}
