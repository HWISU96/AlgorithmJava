package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B3_10872_팩토리얼 {

	// 최종 팩토리얼 결과를 저장할 정적 변수(static variable)
	// main 메소드와 factorial 메소드에서 공유하기 위해 static으로 선언
	static int ans;
	
	public static void main(String[] args) throws IOException {
		// 빠른 입력을 위해 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력받은 문자열을 정수 N으로 변환
		int N = Integer.parseInt(br.readLine());
		
		// 팩토리얼 계산의 항등원인 1로 ans를 초기화
		// N=0 또는 N=1일 경우, 이 값이 그대로 결과가 됨
		ans = 1;
		
		// 재귀 함수 호출을 통해 팩토리얼 계산 시작
		factorial(N);
		
		// 최종 계산된 ans 값을 출력
		System.out.println(ans);
	}
	
	/**
	 * N부터 1까지 수를 곱하여 ans에 누적하는 재귀 함수
	 * @param N 현재 곱해야 할 숫자
	 */
	private static void factorial(int N) {
		// 재귀 종료 조건 (Base Case)
		// N이 1 이하가 되면 더 이상 곱할 필요가 없으므로 재귀를 중단
		// 이 조건 덕분에 0! = 1, 1! = 1이 올바르게 처리됨
		if (N <= 1) {
			return;
		}
		
		// 전역 변수 ans에 현재 N 값을 누적하여 곱함
		ans = ans * N;
		
		// N을 1 감소시켜 자기 자신을 다시 호출 (Recursive Step)
		factorial(N - 1);
	}
}