package 백주니;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 숨바꼭질1 {
	
	static class Point {
		int x;
		int time;
		
		public Point(int x, int time) {
			this.x = x;
			this.time = time;
		}
	}
	
	static int N;
	static int K;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[100001];
		
		if (N == K) {
			System.out.println(0);
			return;
		}
		
		bfs();
		
	} // main
	
	public static void bfs() {
		Deque<Point> deque = new ArrayDeque<>();
		
		deque.add(new Point(N, 0));
		visited[N] = true;
		
		while(!deque.isEmpty()) {
			Point cur = deque.poll();
			
			int[] nextXs = {cur.x - 1, cur.x + 1, cur.x * 2};
			
			for (int nextX : nextXs) {
				if (nextX == K) {
					System.out.println(cur.time + 1);
					return;
				}
				
				if (nextX >= 0 && nextX <= 100000 && !visited[nextX]) {
					visited[nextX] = true;
					deque.add(new Point(nextX, cur.time + 1));
				}
			}
			
		} // while
		
		
	} // bfs
}