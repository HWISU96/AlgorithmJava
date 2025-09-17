import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack; // 스택 자료구조 사용
import java.util.StringTokenizer; // 문자열 분리를 위한 StringTokenizer

public class 스택 { 

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// readLine()은 한 줄을 통째로 읽어오며, 이는 String이므로
		// Integer.parseInt()를 통해 정수 N으로 변환합니다.
		int N = Integer.parseInt(br.readLine());
		
		// 정수를 담을 수 있는 Stack<Integer>를 생성합니다.
		Stack<Integer> stack = new Stack<>();
		
		StringTokenizer st; // 명령어 라인을 파싱할 StringTokenizer 선언
		
		for (int i=0; i<N; i++) {
			// 각 라인마다 새로운 StringTokenizer를 생성하여 명령어를 읽습니다.
			st = new StringTokenizer(br.readLine());
			
			// 명령어 분기: "push" (토큰 2개) vs 그 외 (토큰 1개)
			if (st.countTokens() > 1) {
				// "push" 명령어 처리
				st.nextToken(); // "push" 문자열 토큰을 소비 (사용하지 않으므로)
				// 두 번째 토큰(숫자)을 읽어와 정수로 변환합니다.
				int X = Integer.parseInt(st.nextToken());
				stack.push(X); // 스택에 X를 push합니다.
			} else {
				// "pop", "size", "empty", "top" 명령어 처리
				
				// 핵심: 토큰을 한 번만 읽어서 변수에 저장합니다.
				// 이렇게 하지 않고 else if 마다 nextToken()을 호출하면
				// NoSuchElementException이 발생할 수 있습니다.
				String str = st.nextToken(); 
				
				if (str.equals("top")) {
					// 스택이 비어있으면 -1 출력
					if (stack.isEmpty()) System.out.println(-1);
					// 비어있지 않으면 stack.peek()로 맨 위 원소를 "확인"만 함 (제거 X)
					else System.out.println(stack.peek());
				
				} else if (str.equals("size")) {
					// 스택의 크기(원소 개수)를 출력
					System.out.println(stack.size());
				
				} else if (str.equals("empty")) {
					// 스택이 비어있으면 1 출력
					if (stack.isEmpty()) System.out.println(1);
					// 비어있지 않으면 0 출력
					else System.out.println(0);
				
				} else { // "pop" 명령어 (str.equals("pop"))
					// 스택이 비어있으면 -1 출력
					if (stack.isEmpty()) System.out.println(-1);
					// 비어있지 않으면 stack.pop()로 맨 위 원소를 "제거"하고 반환
					else System.out.println(stack.pop());
				}
			}

		} // for 루프 종료
		
	} // main 종료

} // 클래스 종료