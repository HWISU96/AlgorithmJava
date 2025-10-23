package 백주니;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ISBN {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] isbn = br.readLine().toCharArray();
		
		int check = isbn[12] - '0'; 
		int sum = 0;
		boolean flag = false;
		
		for(int i=0; i<=12; i++) {
			if (isbn[i] == '*') {
				if (i % 2 == 1) {
					flag = true;
					continue;
				}
				else {
					flag = false;
					continue;
				}
			}
			if (i % 2 != 1) {
				sum += isbn[i] -'0';
			}
			else {
				sum += (isbn[i] -'0') * 3;
			}
		}
		
		int result = -1;
		
		if (flag) {
			for (int i=0; i<=9; i++) {
				if ((sum + i*3) % 10 == 0) {
					result = i;
					break;
				}
			}
		}
		else {
			for (int i=0; i<=9; i++) {
				if ((sum + i) % 10 == 0) {
					result = i;
					break;
				}
			}
		}
	
		
		System.out.println(result);
	} // main
}