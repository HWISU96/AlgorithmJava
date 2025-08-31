/**
 * =======================================================================================
 * 문제: SW Expert Academy 7102번 준홍이의 카드놀이 (D3)
 * =======================================================================================
 * * 풀이 의도 및 방법:
 * * 두 개의 카드 덱(1~N, 1~M)이 주어졌을 때, 각 덱에서 카드를 하나씩 뽑아 더했을 때
 * * 나올 수 있는 합계 중 가장 확률이 높은(가장 자주 나오는) 합계를 찾는 문제다.
 * * [접근 방식 - 전체 탐색(Brute-force)]
 * 1. 모든 가능한 카드의 합을 계산하기.
 * - N개의 카드와 M개의 카드로 만들 수 있는 모든 조합(N * M개)을 이중 for문을 통해 탐색
 * - 계산된 모든 합계를 ArrayList에 저장
 * * 2. 가장 빈번하게 등장하는 합계를 찾기.
 * - 먼저, 합계들이 저장된 리스트를 오름차순으로 정렬한다. 이렇게 하면 동일한 합계들이 연속으로 모이게 되어 빈도를 세기 쉬워진다.
 * - 정렬된 리스트를 순회하면서 각 숫자가 몇 번 등장하는지 카운트한다.
 * - '최대 등장 횟수(max_count)'를 기록하는 변수를 두고, 리스트를 순회하며 이 값을 갱신
 * - 만약 현재 숫자의 등장 횟수가 `max_count`보다 크면, `max_count`를 갱신하고 결과 리스트를 비운 뒤 현재 숫자를 추가한다.
 * - 만약 현재 숫자의 등장 횟수가 `max_count`와 같다면, 결과 리스트에 현재 숫자를 추가
 * * 3. 결과를 형식에 맞게 출력합니다.
 * * [더 효율적인 접근 방식 - 아이디어]
 * 합의 범위가 2부터 N+M 까지로 정해져 있으므로, 크기가 (N+M+1)인 배열(countArray)을 선언하고,
 * 모든 합(i+j)이 나올 때마다 `countArray[i+j]`의 값을 1씩 증가시키는 '계수 정렬(Counting Sort)'의 원리를 활용하면
 * 전체 합을 리스트에 저장하고 정렬하는 과정을 생략하여 훨씬 효율적으로 풀 수 있다.
 * */
package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class num7102_D3_준홍이의카드놀이 {

	public static void main(String[] args) throws IOException {
		// 입력을 빠르게 처리하기 위한 BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 총 테스트 케이스의 수를 입력받음
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; t++) {
			// N과 M을 한 줄에서 공백으로 구분하여 입력받음
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 첫 번째 카드 덱의 카드 개수 (1~N)
			int M = Integer.parseInt(st.nextToken()); // 두 번째 카드 덱의 카드 개수 (1~M)
			
            // N과 M으로 만들 수 있는 모든 합의 결과를 저장할 리스트
			List<Integer> list = new ArrayList<>();
			
			// 굳이 배열을 만들 필요 없이, 1~N, 1~M 범위로 반복문을 실행해도 된다.
			// (리스트 풀이를 익히기 위해 리스트 사용)
			int[] arr1 = new int[N];
			int[] arr2 = new int[M];
			for (int i=0; i<N; i++) arr1[i] = i+1;
			for (int i=0; i<M; i++) arr2[i] = i+1;
			
			// 이중 for문을 사용하여 모든 가능한 합을 list에 추가
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					list.add(arr1[i] + arr2[j]);
				}
			}
			
			// 각 합계의 빈도를 효율적으로 계산하기 위해 리스트를 오름차순으로 정렬
			// 예: [4, 5, 3, 4] -> [3, 4, 4, 5]
			list.sort(Comparator.naturalOrder());
			
			// --- 가장 빈번하게 등장하는 숫자(최빈값) 찾기 ---
			int count = 0;             // 현재 숫자의 등장 횟수
			int max_count = 0;         // 지금까지 발견된 최대 등장 횟수
			List<Integer> cList = new ArrayList<>(); // 최빈값을 저장할 결과 리스트
			
			// 정렬된 리스트를 처음부터 끝까지 순회
			for (int i=0; i<list.size(); i++) {
				// 리스트의 첫 번째 요소일 경우, 카운트를 1로 시작
				if (i == 0) {
					count = 1;
					continue; // 다음 반복으로 넘어감
				}

				// 현재 요소(list.get(i))가 이전 요소(list.get(i-1))와 같다면
				if (list.get(i).equals(list.get(i-1))){
					count++; // 등장 횟수 증가
				} else { 
					// 이전 요소와 달라지는 시점 = 한 숫자의 카운팅이 끝난 시점
					// 이전까지 세어 온 count와 max_count를 비교
					if (count > max_count) {
						// 새로운 최빈값 등장
						max_count = count;       // 최대 등장 횟수 갱신
						cList.clear();           // 이전 결과 리스트는 비움
						cList.add(list.get(i-1)); // 새로운 최빈값 추가
					} else if (count == max_count) {
						// 기존 최빈값과 동일한 빈도의 다른 숫자 등장
						cList.add(list.get(i-1)); // 결과 리스트에 추가
					}
					// 다음 숫자를 세기 위해 count를 1로 초기화
					count = 1;
				}
			}

			// ★★★ 중요: 마지막 원소 그룹에 대한 처리 ★★★
			// 위 for문은 숫자가 '바뀔 때'만 max_count와 비교하므로,
			// 리스트의 마지막 숫자(또는 마지막 그룹의 숫자)는 비교 로직을 타지 않고 루프가 종료됨.
			// 따라서 루프가 끝난 후, 마지막으로 세고 있던 count 값을 반드시 한 번 더 비교해주어야 함.
			if (count > max_count) {
				cList.clear();
				cList.add(list.get(list.size()-1));
			} else if (count == max_count) {
				cList.add(list.get(list.size()-1));
			}
			
			// 결과 출력
			// cList에 추가된 숫자들은 이미 오름차순이므로 별도 정렬이 필요 없음.
			System.out.print("#" + t);
			for (int num : cList) {
				System.out.print(" " + num);
			}
			System.out.println();

		} // 테스트 케이스 종료
	}
}