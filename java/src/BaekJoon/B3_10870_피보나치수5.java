import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj10870피보나치수5 {
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(pibo(N));
	}
	
	public static int pibo(int n) {
		if (n <= 0) return 0;
		if (n == 1) return 1;
		
		return pibo(n-1) + pibo(n-2);
	}

}