import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B3_4153_직각삼각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[3];
		StringTokenizer st;
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			
			for (int i=0; i<3; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) break;
			
			Arrays.sort(arr);
			
			int one = arr[0];
			int two = arr[1];
			int thr = arr[2];
			
			if (one*one + two*two == thr*thr) System.out.println("right");
			else System.out.println("wrong");
			
		} // while

	}

}