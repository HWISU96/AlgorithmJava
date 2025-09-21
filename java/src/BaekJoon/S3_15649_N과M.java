package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M {

    // N과 M
    static int N, M;
    
    // 방문 여부를 체크할 배열
    static boolean[] visited; 
    
    // 결과를 담을 배열
    static int[] arr;
    
    // 출력을 빠르게 하기 위한 StringBuilder
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 배열들 초기화
        visited = new boolean[N + 1]; // 1부터 N까지 사용하므로 N+1 크기
        arr = new int[M]; // M개를 뽑으므로 M 크기

        // 백트래킹(DFS) 함수 시작
        // depth 0부터 시작 (아직 아무것도 안 뽑은 상태)
        dfs(0); 

        // 모아둔 출력을 한 번에 처리
        System.out.println(sb.toString());
    }

    static void dfs(int depth) {
        
        // 1. 종료 조건
        // M개를 모두 뽑았다면 (깊이가 M이 되었다면)
        if (depth == M) {
            // arr 배열에 저장된 M개의 숫자를 출력
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n"); // 줄바꿈
            return; // 함수 종료 (한 걸음 뒤로 물러남)
        }

        // 2. 재귀 단계
        // 1부터 N까지의 숫자(갈림길)를 모두 탐색
        for (int i = 1; i <= N; i++) {
            
            // 3. 중복 검사 
            // "아직 방문하지 않은(사용하지 않은) 숫자라면?"
            if (!visited[i]) {
                
                // 4. 선택
                visited[i] = true;  // "i는 사용했다"고 깃발 꽂기
                arr[depth] = i;     // 현재 깊이(depth) 위치에 숫자 i를 기록
                
                // 5. 다음 단계로 이동
                // 다음 숫자 뽑으러 가자 (깊이 1 증가)
                dfs(depth + 1);
                
                // 6. 백트래킹
                // dfs(depth + 1)이 끝났다는 것은,
                // (현재 depth에서 i를 선택한 상태로) 그 하위의 모든 경우의 수를 탐색했다는 뜻.
                // 따라서 "i를 사용 안 함" 상태로 되돌려야 함.
                // (다음 탐색을 위해 깃발 뽑기)
                visited[i] = false; 
            }
        }
    }
}