package 백주니;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 해싱 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		
		long result = 0;
		long power = 1;
		int M = 1234567891;
		
		for (int i=0; i<L; i++) {
			long term = (arr[i] -'a' + 1) * power;
			
			result = (result + term) % M;
			
			power = (power * 31) % M;
		}
		
		System.out.println(result);
		
	} // main
}