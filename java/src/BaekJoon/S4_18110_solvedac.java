package 백주니;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class solvedac {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 의견이 0개일 경우 0 출력 후 종료 (예외 처리)
        if (N == 0) {
            System.out.println(0);
            return;
        }
		
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(list);
		
		int avg = (int) Math.round(N * 0.15);
		double sum = 0;
		for(int i=avg; i<N-avg; i++) {
			sum += list.get(i);
		}
		
		int count = N - 2 * avg;
		int ans = (int) Math.round(sum / count);
		
		System.out.println(ans);
	} // main
}