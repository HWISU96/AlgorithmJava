import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
 
public class 파핑파핑지뢰 {
    static int N;
    static char[][] board; // 지도 원본
    static int [][] nBoard; // 주변 지뢰 체크
    static boolean[][] visited; // 방문 체크
    
    static int[] dx = {-1,1,0,0,-1,-1,1,1}; // 8방향 탐색
    static int[] dy = {0,0,-1,1,-1,1,-1,1};
 
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
 
        for (int t=1; t<=T; t++) {
            N = Integer.parseInt(br.readLine());
            board = new char[N][N];
 
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    board[i][j] = line.charAt(j);
                }
            }
 
            nBoard = new int[N][N];
            for(int i=0; i<N; i++) {
               for (int j=0; j<N; j++) {
                   if (board[i][j] == '*') {
                       nBoard[i][j] = -1;
                       continue;
                   }
     
                   int count = 0;
                   for (int d=0; d<8; d++) {
                       int nx = i + dx[d];
                       int ny = j + dy[d];
                       if (nx >= 0 && ny >=0 && nx < N && ny < N && board[nx][ny] == '*') {
                           count++;
                       }
                   }
                   nBoard[i][j] = count;
               }
            }
 
            int clickCount = 0;
            visited = new boolean[N][N];
 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 0이면서 아직 방문 안 한 곳을 찾으면 클릭
                    if (nBoard[i][j] == 0 && !visited[i][j]) {
                        clickCount++;
                        bfs(i, j);
                    }
                }
            }
 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 지뢰가 아니면서 아직 방문 안 한 곳이 있다면 클릭
                    if (nBoard[i][j] > 0 && !visited[i][j]) {
                        clickCount++;
                    }
                }
            }
 
            // 결과 출력
            System.out.println("#" + t + " " + clickCount);
        }
    }
 
    static void bfs(int startX, int startY) {
        Deque<Point> deque = new ArrayDeque<>();
        deque.offer(new Point(startX, startY));
        visited[startX][startY] = true;
 
        while (!deque.isEmpty()) {
            Point current = deque.poll();
 
            if (nBoard[current.x][current.y] == 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = current.x + dx[i];
                    int ny = current.y + dy[i];
 
                    // 범위 체크 & 방문 여부 체크
                    if (nx >= 0 && ny >=0 && nx < N && ny < N && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        deque.offer(new Point(nx, ny));
                    }
                }
            }
        }
 
    }
 
 
    static class Point {
        int x,y;
        Point(int x, int y) {this.x = x; this.y = y;}
    }
 
}