import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class 좌표정렬하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<Point> points = new ArrayList<>();
		
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			points.add(new Point(x,y));
		}
		
		Collections.sort(points, (p1, p2) -> {
			if (p1.x == p2.x) {
				return p1.y - p2.y;
			} else {
				return p1.x - p2.x;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for (Point p : points) {
			sb.append(p.x).append(" ").append(p.y).append("\n");
		}
		System.out.println(sb);
		
		
	}

}