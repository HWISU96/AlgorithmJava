package 김휘수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj27433팩토리얼2 {
	static long N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Long.parseLong(br.readLine());
		System.out.println(fact(N));
	}

	public static long fact(long n) {
		if (n <= 1)
			return 1;

		return (n * fact(n - 1));
	}

}