package 김휘수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

public class DFS와BFS백준1260 {
	static int N, M, V;                     // N: 정점 개수, M: 간선 개수, V: 시작 정점
    static ArrayList<Integer>[] graph;      // 그래프를 표현할 인접 리스트
    static boolean[] visited;               // 정점 방문 여부를 체크할 배열
    static StringBuilder sb = new StringBuilder(); // 출력을 한번에 처리하기 위한 StringBuilder
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        
        // 그래프(인접 리스트)와 visited 배열을 초기화
        // 정점 번호가 1부터 시작하므로 N+1 크기로 생성
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];
        
        // M개의 간선 정보를 입력받아 그래프를 구성
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            // 양방향 그래프이므로 양쪽 정점에 모두 추가
            graph[u].add(v);
            graph[v].add(u);
        }
        
        // 문제 조건에 따라 각 정점의 인접 리스트를 오름차순으로 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }
        
        // DFS를 수행하고 결과를 StringBuilder에 추가
        dfs(V);
        sb.append("\n"); // DFS와 BFS 결과 사이에 줄바꿈 추가

        // BFS를 수행하기 전에 visited 배열을 false로 초기화
        visited = new boolean[N + 1];
        
        // BFS를 수행하고 결과를 StringBuilder에 추가
        bfs(V);
        
        // 최종 결과를 출력
        System.out.println(sb);
	} // main end
	
	// DFS (재귀 방식으로 구현)
    public static void dfs(int node) {
        // 현재 노드를 방문 처리
        visited[node] = true;
        // 방문한 노드를 StringBuilder에 추가
        sb.append(node).append(" ");
        
        // 현재 노드와 연결된 다른 노드들을 재귀적으로 방문
        for (int nextNode : graph[node]) {
            // 연결된 노드가 아직 방문하지 않았다면
            if (!visited[nextNode]) {
                // 해당 노드를 시작으로 다시 DFS를 수행 (재귀 호출).
                dfs(nextNode);
            }
        }
    } // dfs end
    
    // BFS (큐를 이용해 구현)
    public static void bfs(int startNode) {
        // BFS에 사용할 큐(Deque)를 생성
        Deque<Integer> deque = new ArrayDeque<>();
        
        // 시작 노드를 큐에 넣고 방문 처리
        deque.offer(startNode);
        visited[startNode] = true;
        
        // 큐가 비어있지 않은 동안 반복
        while(!deque.isEmpty()){
            // 큐에서 하나의 노드를 꺼냄
            int currentNode = deque.poll();
            // 꺼낸 노드를 StringBuilder에 추가
            sb.append(currentNode).append(" ");

            // 꺼낸 노드와 연결된 다른 노드들을 확인
            for(int nextNode : graph[currentNode]){
                // 연결된 노드가 아직 방문하지 않았다면
                if(!visited[nextNode]){
                    // 해당 노드를 방문 처리
                    visited[nextNode] = true;
                    // 큐에 추가
                    deque.offer(nextNode);
                }
            }
        }
    } // bfs end
}