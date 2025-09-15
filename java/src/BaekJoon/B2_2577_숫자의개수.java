import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2577숫자의개수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		int ans = A*B*C;
		char[] arr = Integer.toString(ans).toCharArray();
		int[] count = new int[10];
		
		for (int i=0; i<arr.length; i++) {
			count[arr[i]-'0']++;
		}
		
		for (int i=0; i<count.length; i++) {
			System.out.println(count[i]);
		}
	}

}