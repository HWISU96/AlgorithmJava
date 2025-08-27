package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class D2_1974_스도쿠검증 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int[][] arr = new int[10][10]; // +1크기의 2차원 배열 생성

			for (int i = 1; i < 10; i++) {
				for (int j = 1; j < 10; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int result = 1; // 출력할 변수

			for (int i = 1; i < 10; i++) { // 행 체크
				int[] check = new int[10]; // 중복 체크용 배열

				for (int j = 1; j < 10; j++) {
					check[arr[i][j]]++; 
				}
				Arrays.sort(check); // 오름차순 정렬 후
				if (check[9] >= 2) { // 2이상(중복) 값이 있다면 결과 변수에 0
					result = 0;
					break;
				}
			}

			for (int j = 1; j < 10; j++) { // 똑같이 열 체크
				int[] check = new int[10];

				for (int i = 1; i < 10; i++) {
					check[arr[i][j]]++;
				}
				Arrays.sort(check);
				if (check[9] >= 2) {
					result = 0;
					break;
				}
			}

			// 델타 
			int[] rd = { -1, 1, 0, 0, -1, -1, 1, 1 };
			int[] cd = { 0, 0, -1, 1, -1, 1, -1, 1 };

			for (int i = 2; i < 10; i += 3) { // 2, 5, 8번 좌표의 8방만 체크하면 됨
				for (int j = 2; j < 10; j += 3) {
					int[] check = new int[10];

					check[arr[i][j]]++; // 8방+현 자리 체크
					for (int d = 0; d < 8; d++) {
						int rn = rd[d] + i;
						int cn = cd[d] + j;

						check[arr[rn][cn]]++;
					}
					Arrays.sort(check);
					if (check[9] >= 2) {
						result = 0;
						break;
					}
				}
			} // tc end
			System.out.println("#" + t + " " + result);
		}

	}
}