package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 모든순열 {
	static int N;
	
	static boolean[] visited;
	static int[] arr;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		visited = new boolean[N+1];
		arr = new int[N];
		
		dfs(0);
		
		System.out.println(sb.toString());
	} // main

	public static void dfs(int depth) {
		if (depth == N) {
			for (int a : arr) {
				sb.append(a).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i=1; i<=N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[depth] = i;
				
				dfs(depth + 1);
				
				visited[i] = false;				
			}
		}
		
	} // dfs

}
