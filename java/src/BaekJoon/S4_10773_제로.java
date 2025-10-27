package 백주니;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 제로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		long sum = 0;
		
		Deque<Integer> deque = new ArrayDeque<>();
		
		for(int t=1; t<=K; t++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				if (!deque.isEmpty()) {
					sum -= deque.pop();
				}
			}
			else {
				sum += num;
				deque.push(num);
			}
		} // tc
		
		System.out.println(sum);
		
	} // main
}