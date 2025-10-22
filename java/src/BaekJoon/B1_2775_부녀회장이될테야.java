package 백주니;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부녀회장이될테야 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] arr = new int[15][15];
		
		for (int t=1; t<=T; t++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			for(int i=0; i<15; i++) {
				arr[0][i] = i;
			}
			
			for(int i=1; i<15; i++) {
				for(int j=1; j<15; j++) {
					arr[i][j] = arr[i-1][j] + arr[i][j-1];
				}
			} 
			
			System.out.println(arr[k][n]);
			
		} // tc
		
	} // main
}