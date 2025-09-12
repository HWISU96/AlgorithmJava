package 김휘수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 미로탐색 {
	static int N, M;
	static int[][] map; // 미로
	static boolean[][] visited;
	static Deque<Point> deque = new ArrayDeque<>(); // 큐
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];
				
		for (int i=0; i<N; i++) {
			String line = br.readLine();
			for (int j=0; j<M; j++) {
				map[i][j] =line.charAt(j) -'0';
			}
		}
		
		deque.offer(new Point(0,0));
		visited[0][0] = true;
		
		bfs();
		
		System.out.println(map[N-1][M-1]);
		
	} // main
	
	static void bfs() {
		while(!deque.isEmpty()) {
			Point cur = deque.poll();
			int x = cur.x;
			int y = cur.y;
			
			for (int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				
				if (!visited[nx][ny] && map[nx][ny] == 1) {
					visited[nx][ny] = true;
					map[nx][ny] = map[x][y] + 1;
					deque.offer(new Point(nx,ny));
				}
			}
			
			
		} // while
	} // bfs
	
	static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	} // point

}