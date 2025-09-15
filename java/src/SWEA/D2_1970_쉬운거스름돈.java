import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쉬운거스름돈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		
		for (int t=1; t<=T; t++) {
			StringBuilder sb = new StringBuilder();
			int N = Integer.parseInt(br.readLine());
			
			for (int i=0; i<money.length; i++) {
				sb.append(N / money[i]).append(" ");
				N = N % money[i];
			}
			
			System.out.println("#"+t);
			System.out.println(sb);
		} // test
		
	} // main

}
