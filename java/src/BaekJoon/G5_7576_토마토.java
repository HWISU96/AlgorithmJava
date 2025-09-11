import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_백준_7576 {
	static int M, N; // 상자 가로, 세로
	static int[][] box; // 토마토 상태 저장용 2차원 배열
	static Queue<Point> deque = new ArrayDeque<>(); // BFS용 큐(덱으로 구현)
	
	//델타
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		box = new int[N][M]; // 토마토 상자 초기화
		int nomato = 0; // 안익은 토마토 갯수 변수
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				
				// 토마토가 익었다면, BFS의 시작점이 되므로 덱에 추가!
				if (box[i][j] == 1) {
					deque.offer(new Point(i,j));
				}
				else if (box[i][j] == 0) {
					nomato++;
				}
			}
		} // for
		
		// 만약 익은 토마토가 없을 경우, 0을 출력하고 종료
		if (nomato == 0) {
			System.out.println(0);
			return; 
		}
		
		bfs();
		
		int day = 0; // 토마토가 모두 익는 일수 저장 변수
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				// 만약 bfs가 끝났는데도 0이 있다면, -1을 출력
				if (box[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				day = Math.max(day, box[i][j]); // box[i][j]값은 토마토가 익은 날짜를 의미하므로, 가장 큰 값을 찾는다!
			}
		}
		// 시작을 1부터 했으므로, 최종 일수에서 1을 빼야한다.
		System.out.println(day-1);
	}
	
	static class Point { // 좌표를 저장하기 위한 클래스
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void bfs() {
		// 덱이 빌때까지 반복
		while(!deque.isEmpty()) {
			// 덱의 맨앞에서 탐색할 토마토 꺼내기
			Point cur = deque.poll();
			int x = cur.x;
			int y = cur.y;
			
			// 해당 토마토의 4방 탐색
			for (int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
			
			if (nx < 0 || ny < 0 || nx >= N || ny >=M ) {
				continue;
			}
			
			if (box[nx][ny] == 0) {
				box[nx][ny] = box[x][y] +1;
				deque.offer(new Point(nx,ny));
			}
			
			}
		}
		
	} // bfs end
	
	
}