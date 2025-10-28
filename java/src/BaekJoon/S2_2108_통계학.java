package 백주니;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 통계학 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		double sum = 0;
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		int avg = (int) Math.round(sum / N);
		sb.append(avg).append("\n");
		
		Arrays.sort(arr);
		sb.append(arr[N/2]).append("\n");
		
		// 최빈값
		int[] count = new int[8001];
		for(int i=0; i<N; i++) {
			count[arr[i] + 4000]++;
		}

		int max = 0;
        for (int i = 0; i < 8001; i++) {
            if (count[i] > max) {
                max = count[i];
            }
        }
        
        // 최빈값들을 저장할 리스트
        List<Integer> lists = new ArrayList<>();
        for (int i = 0; i < 8001; i++) {
            if (count[i] == max) {
                // 다시 원래 숫자로 돌리기 위해 4000을 빼줌
                lists.add(i - 4000);
            }
        }
        
        // 최빈값이 여러 개일 경우, 두 번째로 작은 값을 출력해야 하므로
        // 리스트는 이미 오름차순으로 채워져 있으므로 별도 정렬은 필요 없음
        if (lists.size() > 1) {
            sb.append(lists.get(1)).append("\n");
        } else {
        	sb.append(lists.get(0)).append("\n");
        }
		
		sb.append(arr[N-1]-arr[0]).append("\n");
		
		
		System.out.println(sb.toString());
		
	} // main
}
