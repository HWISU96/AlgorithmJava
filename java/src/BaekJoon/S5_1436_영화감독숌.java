package 백주니;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 영화감독숌 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		int num = 666;
		boolean check;
		
		while(N != count) {
			String str = String.valueOf(num);
			check = str.contains("666");
			if (check) {
				count++;
			}
			num++;
		} // while
		System.out.println(num-1);
	} //main
}