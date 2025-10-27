package 백주니;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		// true: 소수, false: 소수 아님
        boolean[] isPrime = new boolean[N + 1];
        
        // 배열을 모두 true로 초기화
        for (int i = 0; i <= N; i++) {
            isPrime[i] = true;
        }
        
        // 소수가 아닌 0과 1은 false로 처리
        isPrime[0] = isPrime[1] = false;
        
        // 2부터 N의 제곱근까지 반복하며 배수를 제거
        // i * i > N 이면 더 이상 확인할 필요가 없음
        for (int i = 2; i * i <= N; i++) {
            // i가 소수라면 (아직 지워지지 않았다면)
            if (isPrime[i]) {
                // i의 배수들을 모두 false로 변경 (i*i 이전의 배수들은 이미 처리됨)
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // M부터 N까지의 소수 출력
        for (int i = M; i <= N; i++) {
            if (isPrime[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
		
	} // main
}