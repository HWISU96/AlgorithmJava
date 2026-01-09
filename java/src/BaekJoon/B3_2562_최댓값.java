package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class B3_2562_최댓값 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[9];
		int max = 0;
		int count = 0;
	
		for (int t=0; t<9; t++) {
			arr[t] = Integer.parseInt(br.readLine());
		}
		
		for (int t=0; t<9; t++) {
			if (arr[t] > max) {
				max = arr[t];
				count = t+1;
			}
		}
		
		System.out.println(max);
		System.out.println(count);
	}
}