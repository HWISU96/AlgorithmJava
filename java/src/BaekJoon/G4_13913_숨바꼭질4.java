import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class 숨바꼭질4 {

	static int N, K, T;
	static int[] move = new int[100001];
	static boolean[] visited = new boolean[100001];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if (N >= K) {
			System.out.println(N - K);
			for (int i=N; i>=K; i--) {
				System.out.print(i + " ");
			}
			return;
		}
		
		bfs();
		
		Stack<Integer> path = new Stack<>();
		int idx = K;
		while (idx != N) {
			path.push(idx);
			idx = move[idx];
		}
		path.push(N);
		
		while(!path.isEmpty()) {
			sb.append(path.pop()).append(" ");
		}
		
		System.out.println(sb.toString());
		
	} // main
	
	public static void bfs() {
		Deque<Point> deque = new ArrayDeque<>();
		
		deque.add(new Point(N, 0));
		visited[N] = true;
		
		while(!deque.isEmpty()) {
			Point cur = deque.poll();
			int curNow = cur.now;
			int curTime = cur.time;
			
			if (curNow == K) {
				sb.append(curTime).append("\n");
				return;
			}
			
			int[] nextNows = {curNow - 1, curNow + 1, curNow * 2};
			
			for (int nextNow : nextNows) {
				if (nextNow >= 0 && nextNow <=100000 && !visited[nextNow]) {
					visited[nextNow] = true;
					move[nextNow] = curNow;
					deque.add(new Point(nextNow, curTime + 1));
				}
			}
			
			
		} // while
		
	} // bfs
	
	
	static class Point {
		int now;
		int time;
		
		public Point(int now, int time) {
			this.now = now;
			this.time = time;
		}
	} // Point
	
}